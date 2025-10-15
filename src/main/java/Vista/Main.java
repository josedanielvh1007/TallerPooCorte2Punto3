/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package Vista;

import javax.swing.JOptionPane;
import Modelo.*;
import java.util.ArrayList;

/**
 *
 * @author jose
 */
public class Main {

    ArrayList<Cliente> clientes = new ArrayList<>();

    public static void main(String[] args) {
        Main app = new Main();
        app.run();
    }

    private void run() {
        int option;

        do {
            option = Integer.parseInt(JOptionPane.showInputDialog("""
                                                                  Menu : 
                                                                  1. Añadir cliente.
                                                                  2. Listar clientes.
                                                                  3. Operaciones con clientes.
                                                                  4. Cargar datos de ejemplo.
                                                                  0. Salir."""));
            switch (option) {
                case 1 ->
                    anadirCliente();
                case 2 ->
                    listarClientes();
                case 3 ->
                    operacionesClientes();
                case 4 ->
                    cargarDatosEjemplo();
            }
        } while (option != 0);
    }

    private void anadirCliente() {
        int cantInic = clientes.size();
        int tipoCliente = Integer.parseInt(JOptionPane.showInputDialog("""
                                                                       Tipo de cliente : 
                                                                       1. Natural.
                                                                       2. Jurídico."""));
        String nombre = JOptionPane.showInputDialog("Nombre");
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Edad"));
        switch (tipoCliente) {
            case 1 ->
                clientes.add(new ClienteNatural(nombre, edad));
            case 2 ->
                clientes.add(new ClienteJuridico(nombre, edad));
        }

        if (clientes.size() == cantInic + 1) {
            JOptionPane.showMessageDialog(null, "Cliente añadido exitosamente...");
        } else {
            JOptionPane.showMessageDialog(null, "Hubo un error. Por favor intente nuevamente.");
        }
    }

    private void listarClientes() {
        String texto = "";
        if (clientes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Primero debe añadir clientes");
        } else {
            for (Cliente cli : clientes) {
                texto += cli.toString() + "\n---------------------------------------------\n";
            }
        }
        JOptionPane.showMessageDialog(null, texto);
    }

    private void operacionesClientes() {
        int option;
        do {
            option = Integer.parseInt(JOptionPane.showInputDialog("""
                                                                  Menu : 
                                                                  1. Añadir cuenta.
                                                                  2. Listar cuentas.
                                                                  3. Transacciones.
                                                                  0. Salir."""));
            switch (option) {
                case 1 ->
                    anadirCuenta();
                case 2 ->
                    listarCuenta();
                case 3 ->
                    transaccionCuenta();
            }
        } while (option != 0);
    }

    private void anadirCuenta() {
        String texto = "";
        int cuentasExistentes = 0;
        for (Cliente cli : clientes) {
            texto += "\n  - " + cli.getNombre();
            cuentasExistentes += cli.getCuentas().size();
        }
        String nombreCliente = JOptionPane.showInputDialog("¿Para quién desea añadir una cuenta?\n" + texto);

        int cuentasIniciales;

        for (Cliente cli : clientes) {
            if (cli.getNombre().contains(nombreCliente)) {
                cuentasIniciales = cli.getCuentas().size();
                cli.anadirCuenta(cuentasExistentes + 1);
                if (cuentasIniciales + 1 == cli.getCuentas().size()) {
                    JOptionPane.showMessageDialog(null, "Cuenta añadida correctamente....");
                } else {
                    JOptionPane.showMessageDialog(null, "Error. Por favor intente nuevamente.");
                }
            }
        }
    }

    private void listarCuenta() {
        String texto = "";
        for (Cliente cli : clientes) {
            texto += "\n  - " + cli.getNombre();
        }
        String nombreCliente = JOptionPane.showInputDialog("¿Para quién desea visualizar las cuentas?\n" + texto);

        for (Cliente cli : clientes) {
            if (cli.getNombre().contains(nombreCliente)) {
                JOptionPane.showMessageDialog(null, "Información cuentas \n---------------------------------------------\n" + cli.listarCuentas());
            }
        }
    }

    private void transaccionCuenta() {
        String texto = "";
        for (Cliente cli : clientes) {
            texto += "\n  - " + cli.getNombre();
        }
        String nombreCliente = JOptionPane.showInputDialog("¿Para quién desea realizar una transacción?\n" + texto);
        int numeroCuenta = 0;
        double valorTransaccion = 0;
        int tipoTransaccion = 2;
        for (Cliente cli : clientes) {
            if (cli.getNombre().contains(nombreCliente)) {
                numeroCuenta = Integer.parseInt(JOptionPane.showInputDialog("¿A qué cuenta desea realizar la transacción?\n" + cli.listarCuentas()));
                tipoTransaccion = Integer.parseInt(JOptionPane.showInputDialog("Tipo de transacción : \n1. Retiro. \n2. Consignación."));
                valorTransaccion = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto"));
            }
        }

        if (tipoTransaccion == 1) {
            valorTransaccion = -valorTransaccion;
        }

        for (Cliente cli : clientes) {
            if (cli.getNombre().contains(nombreCliente)) {
                cli.consignacion(numeroCuenta, valorTransaccion);
            }
        }
    }

    private void cargarDatosEjemplo() {
        // Crear algunos clientes de ejemplo
        ClienteNatural c1 = new ClienteNatural("Juan Pérez", 30);
        ClienteNatural c2 = new ClienteNatural("María Gómez", 25);
        ClienteJuridico c3 = new ClienteJuridico("TechCorp S.A.", 5);

        // Añadir cuentas a los clientes
        c1.anadirCuenta(1);
        c1.anadirCuenta(2);
        c2.anadirCuenta(3);
        c3.anadirCuenta(4);

        // (Opcional) Puedes hacer algunas consignaciones iniciales
        c1.consignacion(1, 500000);
        c2.consignacion(3, 1000000);
        c3.consignacion(4, 10000000);

        // Agregar clientes al ArrayList principal
        clientes.add(c1);
        clientes.add(c2);
        clientes.add(c3);

        JOptionPane.showMessageDialog(null, "Datos de ejemplo cargados correctamente ✅");
    }
}
