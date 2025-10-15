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
                                                                  2. Listar clientes."""));
            switch (option) {
                case 1 -> anadirCliente();
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
            case 1 -> clientes.add(new ClienteNatural(nombre, edad));
            case 2 -> clientes.add(new ClienteJuridico(nombre, edad));
        }
        
        if (clientes.size() == cantInic + 1) {
            JOptionPane.showMessageDialog(null, "Cliente añadido exitosamente...");
        } else {
            JOptionPane.showMessageDialog(null, "Hubo un error. Por favor intente nuevamente.");
        }
    }
}
