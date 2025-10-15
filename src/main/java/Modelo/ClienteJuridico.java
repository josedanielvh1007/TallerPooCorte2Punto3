/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author jose
 */
public class ClienteJuridico extends Cliente {

    public ClienteJuridico(String nombre, int edad) {
        super(nombre, edad);
    }
    
    @Override
    public String tipoCliente() {
        return "Juridico";
    }
    
}
