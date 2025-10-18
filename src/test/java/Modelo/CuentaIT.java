/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Modelo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

/**
 *
 * @author jose
 */
public class CuentaIT {

    ArrayList<Cuenta> cuentas = new ArrayList<>();

    @BeforeEach
    public void crearCuentas() {
        cuentas = new ArrayList<>();
        cuentas.add(new CuentaAhorros(1, "18-10-2025"));
        cuentas.add(new CuentaCorriente(2, "18-10-2025"));
        cuentas.add(new CuentaAhorros(3, "18-10-2025"));
    }

    @Test
    public void consignacion() {
        for (Cuenta cta : cuentas) {
            cta.consignacion(25000);
            System.out.println("Consignación de 25000...");
            assertEquals(25000, cta.getSaldo());

            System.out.println("Retiro de 5000...");
            cta.consignacion(-5000);
            assertEquals(20000, cta.getSaldo());
        }
    }

    @Test
    public void tipoCuenta() {
        System.out.println("Tipos de cuenta...");

        int index = 0;
        for (Cuenta cta : cuentas) {
            index++;
            switch (index) {
                case 1 ->
                    assertEquals("Ahorros", cta.getTipoCuenta());
                case 2 ->
                    assertEquals("Corriente", cta.getTipoCuenta());
                case 3 ->
                    assertEquals("Ahorros", cta.getTipoCuenta());
            }
        }
    }

    @Test
    public void fechaApertura() {
        for (Cuenta cta : cuentas) {
            assertEquals("18-10-2025", cta.getFechaApertura());
        }
    }
}
