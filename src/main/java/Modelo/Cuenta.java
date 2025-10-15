/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import javax.swing.JOptionPane;

/**
 *
 * @author jose
 */
public class Cuenta {

    private final int numeroCuenta;
    double saldo;
    private final String fechaApertura;
    protected double sobreGiro;

    public Cuenta(int numeroCuenta, String fechaApertura) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = 0;
        this.fechaApertura = fechaApertura;
        this.sobreGiro = 0;
    }

    public void consignacion(double valorConsignacion) {
        if ((saldo += valorConsignacion) >= sobreGiro) {
            saldo += valorConsignacion;
        } else {
            JOptionPane.showMessageDialog(null, "Error : No hay saldo suficiente");
        };
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }
    
    public String getTipoCuenta() {
        return "";
    }

    public String getFechaApertura() {
        return fechaApertura;
    }

    @Override
    public String toString() {
        return numeroCuenta + " : "
                + "\n  - Apertura : " + fechaApertura
                + "\n  - Saldo : " + saldo;
    }

}
