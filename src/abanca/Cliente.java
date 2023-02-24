/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abanca;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class Cliente {

    String Dni;
    String nombre;
    String Direccion;
    int edad;

    public Cliente(String Dni, String nombre, String Direccion, int edad) {
        this.Dni = Dni;
        this.nombre = nombre;
        this.Direccion = Direccion;
        this.edad = edad;
        
    }
    
    public static Cliente BuscarCliente(ArrayList<Cliente> Client) {
        Scanner sn = new Scanner(System.in);
        System.out.println("Dni de cliente:");
        String DNI = sn.next();
       
        Cliente busc = null;
        for (int i = 0; i < Client.size(); i++) {
            if (Client.get(i).Dni.equalsIgnoreCase(DNI)) {
                busc = Client.get(i);
            }
        }
        return busc;
    }
    
    public void VerCliente() {
        System.out.println("Nombre del cliente: " + this.nombre
                + " " + this.edad + " Anios"
                + "\nDireccion " + this.Direccion + "\n");
    }
    public static void VerTodosClientes(ArrayList<Cliente> Client){
        for (int i = 0; i < Client.size(); i++) {
            Client.get(i).VerCliente();
        }
    }
    
}
