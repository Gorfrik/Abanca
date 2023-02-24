
package abanca;

import java.util.ArrayList;
import java.util.Scanner;


public class CuentaCorriente extends CuentaBancaria{
    
    private double Comision;
    private double intereses;
    private int N_Targeta;
    
    private static int Cont_targ=8570;

    public CuentaCorriente(double Comision, double intereses, double saldo, Cliente nuevo) {
        super(saldo, nuevo);
        Cont_targ++;
        this.Comision = Comision;
        this.intereses = intereses;
        this.N_Targeta = Cont_targ;
    }

    public static void VerCuentaCorriente(ArrayList<CuentaCorriente> CCorriente) {

        boolean comprobar = true;
        int resp = CuentaCorriente.buscarClienteCuenCorriente(CCorriente);
        if (resp != -1) {
            System.out.println("ID: " + CCorriente.get(resp).Id
                    + "\nSaldo " + CCorriente.get(resp).getSaldo()
                    + "\nFecha de apertura: " + CCorriente.get(resp).FechaApertura);
            System.out.println("------------------------");
            for (int k = 0; k < CCorriente.get(resp).Titular.size(); k++) {
                System.out.println("Cliente " + k + 1);
                CCorriente.get(resp).Titular.get(k).VerCliente();
                comprobar = false;
                System.out.println("Tiene una comision de: "+ CCorriente.get(resp).Comision
                        +"\nUnos intereses de: "+CCorriente.get(resp).intereses
                        +"\nSu numero de targeta es: "+CCorriente.get(resp).N_Targeta+"\n");
            }

            if (comprobar) {
                System.out.println("Titular da le cuenta: null");
            }
        } else {
            System.out.println("No se encontro la cuenta");
        }
    }
    
    public static int buscarClienteCuenCorriente(ArrayList<CuentaCorriente> CCorriente) {
        Scanner sn = new Scanner(System.in);
        System.out.println("Cual es el dni del titular?");
        String Dni = sn.next();
        int resp = -1;
        
        for (int i = 0; i < CCorriente.size(); i++) {
            for (int j = 0; j < CCorriente.get(i).Titular.size(); j++) {
                if (CCorriente.get(i).Titular.get(j).Dni.equalsIgnoreCase(Dni)) {
                    
                    resp = i;
                }
            }
        }

        return resp;
    }
    
    public double getComision() {
        return Comision;
    }

    public void setComision(double Comision) {
        this.Comision = Comision;
    }

    public double getIntereses() {
        return intereses;
    }

    public void setIntereses(double intereses) {
        this.intereses = intereses;
    }

    public int getN_Targeta() {
        return N_Targeta;
    }

    public void setN_Targeta(int N_Targeta) {
        this.N_Targeta = N_Targeta;
    }
    
    
    
}
