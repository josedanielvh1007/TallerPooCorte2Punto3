/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author jose
 */
public class CuentaAhorros extends Cuenta {

    public CuentaAhorros(int numeroCuenta, String fechaApertura) {
        super(numeroCuenta, fechaApertura);
    }
    
    public String getTipoCuenta() {
        return "Ahorros";
    }
    
}
