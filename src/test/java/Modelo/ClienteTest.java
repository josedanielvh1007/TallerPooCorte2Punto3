package Tests;

import Modelo.ClienteJuridico;
import Modelo.ClienteNatural;
import Modelo.CuentaAhorros;
import Modelo.CuentaCorriente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class ClienteTest {

    private ClienteNatural clienteNatural;
    private ClienteJuridico clienteJuridico;

    @BeforeEach
    void setUp() {
        clienteNatural = new ClienteNatural("Juan Pérez", 30);
        clienteJuridico = new ClienteJuridico("TechCorp S.A.", 5);
    }

    @Test
    void testTipoCliente() {
        assertEquals("Natural", clienteNatural.tipoCliente());
        assertEquals("Juridico", clienteJuridico.tipoCliente());
    }

    @Test
    void testAgregarCuentaAhorros() {
        // Creamos una cuenta manualmente (sin usar JOptionPane)
        CuentaAhorros cuenta = new CuentaAhorros(1, "01-01-2025");
        clienteNatural.getCuentas().add(cuenta);

        assertEquals(1, clienteNatural.getCuentas().size());
        assertTrue(clienteNatural.getCuentas().get(0) instanceof CuentaAhorros);
    }

    @Test
    void testAgregarCuentaCorriente() {
        CuentaCorriente cuenta = new CuentaCorriente(2, "01-01-2025");
        clienteJuridico.getCuentas().add(cuenta);

        assertEquals(1, clienteJuridico.getCuentas().size());
        assertTrue(clienteJuridico.getCuentas().get(0) instanceof CuentaCorriente);
    }

    @Test
    void testConsignacionAhorros() {
        CuentaAhorros cuenta = new CuentaAhorros(1, "01-01-2025");
        clienteNatural.getCuentas().add(cuenta);

        double saldoInicial = cuenta.getSaldo();
        clienteNatural.consignacion(1, 500000);

        assertEquals(saldoInicial + 500000, cuenta.getSaldo());
    }

    @Test
    void testRetiroEnCuentaCorrienteConSobregiro() {
        CuentaCorriente cuenta = new CuentaCorriente(2, "01-01-2025");
        clienteJuridico.getCuentas().add(cuenta);

        // Consignamos algo
        clienteJuridico.consignacion(2, 50000);
        assertEquals(50000, cuenta.getSaldo());

        // Retiramos más del saldo (permitido hasta -100000)
        clienteJuridico.consignacion(2, -120000);

        // Debe respetar el límite del sobregiro (-100000)
        assertEquals(-70000, cuenta.getSaldo());
    }

    @Test
    void testToStringCliente() {
        String texto = clienteNatural.toString();
        assertTrue(texto.contains("Juan Pérez"));
        assertTrue(texto.contains("Edad"));
    }

    @Test
    void testListarCuentas() {
        clienteNatural.getCuentas().add(new CuentaAhorros(1, "01-01-2025"));
        clienteNatural.getCuentas().add(new CuentaCorriente(2, "01-02-2025"));
        String lista = clienteNatural.listarCuentas();

        assertTrue(lista.contains("Ahorros"));
        assertTrue(lista.contains("Corriente"));
    }
}
