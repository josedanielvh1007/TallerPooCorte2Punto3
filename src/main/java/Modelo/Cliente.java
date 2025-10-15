/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jose
 */
public class Cliente {

    protected final String nombre;
    protected final int edad;
    ArrayList<Cuenta> cuentas;

    public Cliente(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.cuentas = new ArrayList<>();
    }

    public void anadirCuenta(int numeroCuenta) {
        String fechaApertura = JOptionPane.showInputDialog("Ingrese la fecha (dd-mm-yyyy)");
        int option = 20;

        while (option != 0 && option != 1 && option != 2) {
            option = Integer.parseInt(JOptionPane.showInputDialog("""
                                                                  Tipo de cuenta : 
                                                                  1. Ahorros.
                                                                  2. Corriente."""));
        }
        switch (option) {
            case 1 ->
                cuentas.add(new CuentaAhorros(numeroCuenta, fechaApertura));
            case 2 ->
                cuentas.add(new CuentaCorriente(numeroCuenta, fechaApertura));
        }
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Cuenta> getCuentas() {
        return cuentas;
    }

    public String tipoCliente() {
        return "";
    }

    public void listarCuentas() {
        String texto = "Información cuentas \n---------------------------------------------\n";
        for (Cuenta cnt : cuentas) {
            texto += "  - Cuenta : " + cnt.getNumeroCuenta()
                    + "\n  - Saldo : " + cnt.getSaldo() 
                    + "\n  - Tipo de cuenta : " + cnt.getTipoCuenta() 
                    + "\n---------------------------------------------\n";
        }
        
        JOptionPane.showMessageDialog(null, texto);
    }

    @Override
    public String toString() {
        return nombre + "\n  - Edad : " + edad + "\n  - Total cuentas : " + cuentas.size();
    }
}
