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
                                                                  3. Operaciones con clientes."""));
            switch (option) {
                case 1 ->
                    anadirCliente();
                case 2 ->
                    listarClientes();
                case 3 ->
                    operacionesClientes();
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
                                                                  3. Transacciones."""));
            switch (option) {
                case 1 -> anadirCuenta();
                case 2 -> listarCuenta();
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
                cli.listarCuentas();
            }
        }
    }
}
