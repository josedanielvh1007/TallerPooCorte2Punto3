/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author jose
 */
public class ClienteNatural extends Cliente {

    public ClienteNatural(String nombre, String edad) {
        super(nombre, edad);
    }
    
    @Override
    public String tipoCliente() {
        return "Natural";
    }
    
}
