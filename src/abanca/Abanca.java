package abanca;

import java.util.ArrayList;
import java.util.Scanner;

public class Abanca {

    public static void MENU() {
        System.out.println("1).Dar de alta a un cliente");
        System.out.println("2).Visualizar un cliente");
        System.out.println("3).Dar de alta una cuenta bancaria");
        System.out.println("4).Ver una cuenta bancaria");
        System.out.println("5).Modificar un titular de una cuenta bancaria");
        System.out.println("6).Dar de alta una cuenta corriente");
        System.out.println("7).Ver una cuenta corriente");
        System.out.println("8).Dar de alta una cuenta de ahorros");
        System.out.println("9).Ver una cuenta de ahorros");
        System.out.println("10).Modificar saldo");
        System.out.println("11).Salir");
    }

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        ArrayList<Cliente> Client = new ArrayList();
        ArrayList<CuentaBancaria> Banca = new ArrayList();
        ArrayList<CuentaCorriente> CCorriente = new ArrayList();
        ArrayList<CuentaAhorros> CAhorros = new ArrayList();

        Cliente cliente1 = new Cliente("1", "Paco", "pacolandia", 28);
        Client.add(cliente1);
        Cliente cliente2 = new Cliente("2", "Ana", "analandia", 34);
        Client.add(cliente2);
        Cliente cliente3 = new Cliente("3", "Manolo", "manolandia", 67);
        Client.add(cliente3);
        CuentaBancaria CBa = new CuentaBancaria(1000, Client.get(0));
        Banca.add(CBa);
        CuentaCorriente CCo=new CuentaCorriente(2.5, 0.5, 1500, Client.get(1));
        CCorriente.add(CCo);
        CuentaAhorros CAh=new CuentaAhorros(50, "1/1/2030", 1350, Client.get(2));
        CAhorros.add(CAh);
        int caso;
        do {
            MENU();
            caso = sn.nextInt();
            switch (caso) {
                case 1:
                    System.out.println("Dni:");
                    String Dni = sn.next();
                    System.out.println("Nombre:");
                    String nombre = sn.next();
                    System.out.println("Direccion:");
                    String Direccion = sn.next();
                    System.out.println("Edad");
                    int edad = sn.nextInt();
                    Cliente cli = new Cliente(Dni, nombre, Direccion, edad);
                    Client.add(cli);
                    Cliente.VerTodosClientes(Client);
                    break;
                case 2:
                    Cliente busc = Cliente.BuscarCliente(Client);
                    if (busc != null) {
                        busc.VerCliente();
                    } else {
                        System.out.println("No se encotro Cliente");
                    }
                    break;
                case 3:
                    Cliente selec = Cliente.BuscarCliente(Client);
                    if (selec != null) {
                        System.out.println("De cuanto va a ser su primer ingreso:");
                        double saldo=sn.nextDouble();
                        CuentaBancaria CB = new CuentaBancaria(saldo, selec);
                        Banca.add(CB);
                    } else {
                        System.out.println("No se encontro al cliente");
                    }
                    break;
                case 4:
                    CuentaBancaria.VerCuenta(Banca);
                    break;
                case 5:
                    CuentaBancaria.ModificarTitular(Banca, Client);
                    break;
                case 6:
                    System.out.println("Que comision va a tener?");
                    double comision=sn.nextDouble();
                    System.out.println("Que intereses va a tener?");
                    double intereses=sn.nextDouble();
                    System.out.println("Que saldo va a tener?");
                    double saldo=sn.nextDouble();
                    Cliente Nuevo=Cliente.BuscarCliente(Client);
                    CuentaCorriente CC=new CuentaCorriente(comision, intereses, saldo, Nuevo);
                    CCorriente.add(CC);
                    break;
                case 7:
                    CuentaCorriente.VerCuentaCorriente(CCorriente);
                    break;
                case 8:
                    System.out.println("Cual es el saldo minimo?");
                    double saldoM=sn.nextDouble();
                    System.out.println("Cual es el plazo de retirada?");
                    String plazo=sn.next();
                    System.out.println("Que saldo va a tener?");
                    double saldo2=sn.nextDouble();
                    Cliente Nuevo2=Cliente.BuscarCliente(Client);
                    CuentaAhorros CA=new CuentaAhorros(saldoM, plazo, saldo2, Nuevo2);
                    CAhorros.add(CA);
                    break;
                case 9:
                    CuentaAhorros.VerCuentaAhorros(CAhorros);
                    break;
                case 10:
                    CuentaBancaria.ModificarSaldo(Banca, CCorriente, CAhorros);
                    break;
                case 11:
                    break;
            }
        } while (caso != 11);
        System.out.println("Fin");

    }

}
