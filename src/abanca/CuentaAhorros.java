package abanca;

import java.util.ArrayList;
import java.util.Scanner;

public class CuentaAhorros extends CuentaBancaria {

    private double SaldoMinimo;
    private String plazoRetirada;

    public CuentaAhorros(double SaldoMinimo, String plazoRetirada, double saldo, Cliente nuevo) {

        super(saldo, nuevo);
        this.SaldoMinimo = SaldoMinimo;
        this.plazoRetirada = plazoRetirada;

    }

     public static void VerCuentaAhorros(ArrayList<CuentaAhorros> CAhorros) {

        boolean comprobar = true;
        int resp = CuentaAhorros.buscarClienteCuenahorro(CAhorros);
        if (resp != -1) {
            System.out.println("ID: " + CAhorros.get(resp).Id
                    + "\nSaldo " + CAhorros.get(resp).getSaldo()
                    + "\nFecha de apertura: " + CAhorros.get(resp).FechaApertura);
            System.out.println("------------------------");
            for (int k = 0; k < CAhorros.get(resp).Titular.size(); k++) {
                System.out.println("Cliente " + k + 1);
                CAhorros.get(resp).Titular.get(k).VerCliente();
                comprobar = false;
                System.out.println("Saldo minimo: "+CAhorros.get(resp).SaldoMinimo
                        +"\nPlazo de retirada: "+CAhorros.get(resp).plazoRetirada+"\n");
            }

            if (comprobar) {
                System.out.println("Titular da le cuenta: null");
            }
        } else {
            System.out.println("No se encontro la cuenta");
        }
    }
     public static int buscarClienteCuenahorro(ArrayList<CuentaAhorros> CAhorros) {
        Scanner sn = new Scanner(System.in);
        System.out.println("Cual es el dni del titular?");
        String Dni = sn.next();
        int resp = -1;
        
        for (int i = 0; i < CAhorros.size(); i++) {
            for (int j = 0; j < CAhorros.get(i).Titular.size(); j++) {
                if (CAhorros.get(i).Titular.get(j).Dni.equalsIgnoreCase(Dni)) {
                    resp = i;
                }
            }
        }
        return resp;
    }

    public double getSaldoMinimo() {
        return SaldoMinimo;
    }

    public void setSaldoMinimo(double SaldoMinimo) {
        this.SaldoMinimo = SaldoMinimo;
    }

    public String getPlazoRetirada() {
        return plazoRetirada;
    }

    public void setPlazoRetirada(String plazoRetirada) {
        this.plazoRetirada = plazoRetirada;
    }
    
    
    
}
