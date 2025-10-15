/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author jose
 */
public class CuentaCorriente extends Cuenta {

    public CuentaCorriente(int numeroCuenta, String fechaApertura) {
        super(numeroCuenta, fechaApertura);
        this.sobreGiro = -100000;
    }

    @Override
    public String getTipoCuenta() {
        return "Corriente";
    }

    @Override
    public String toString() {
        return super.toString() + "\n  - Tipo de cuenta : " + this.getTipoCuenta()
                + "\n  - Sobregiro : " + (-sobreGiro);
    }
}
