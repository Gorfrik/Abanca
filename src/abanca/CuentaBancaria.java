package abanca;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class CuentaBancaria {

    int Id;
    ArrayList<Cliente> Titular = new ArrayList();
    private double saldo;
    LocalDate FechaApertura;
    private static int contador = 0;

    public CuentaBancaria(double saldo, Cliente titul) {
        contador++;
        this.Id = contador;
        this.saldo = saldo;
        this.FechaApertura = LocalDate.now();
        Titular.add(titul);
    }

    public static void VerCuenta(ArrayList<CuentaBancaria> banca) {

        boolean comprobar = true;
        int resp = CuentaBancaria.buscarClienteCuenBanc(banca);
        if (resp != -1) {
            System.out.println("ID: " + banca.get(resp).Id
                    + "\nSaldo " + banca.get(resp).saldo
                    + "\nFecha de apertura: " + banca.get(resp).FechaApertura);
            System.out.println("------------------------");
            for (int k = 0; k < banca.get(resp).Titular.size(); k++) {
                System.out.println("Cliente " + k + 1);
                banca.get(resp).Titular.get(k).VerCliente();
                comprobar = false;

            }

            if (comprobar) {
                System.out.println("Titular da le cuenta: null");
            }
        } else {
            System.out.println("No se encontro la cuenta");
        }
    }

    public static void ModificarTitular(ArrayList<CuentaBancaria> banca, ArrayList<Cliente> Client) {
        Scanner sn = new Scanner(System.in);
        int resp = CuentaBancaria.buscarClienteCuenBanc(banca);
        if (resp != -1) {
            System.out.println("Que Modificacion deseas realizar");
            System.out.println("1.Añadir otro titular a la cuenta."
                    + "\n2.Modifucar el titular de la cuenta."
                    + "\n3.Eliminar un titular de la cuenta.");
            int caso = sn.nextInt();
            do {
                switch (caso) {
                    case 1:
                        Cliente devuelto = Cliente.BuscarCliente(Client);
                        banca.get(resp).Titular.add(devuelto);
                        System.out.println("Titular añadido");
                        caso=4;
                        break;
                    case 2:
                        Cliente clie = Cliente.BuscarCliente(banca.get(resp).Titular);
                        if (clie != null) {
                            if (banca.get(resp).Titular.size() == 1) {
                                System.out.println("Que cliente va a sera ahora el titular de la cuenta?");
                                Cliente encontrado = Cliente.BuscarCliente(Client);
                                if (encontrado != null) {
                                    banca.get(resp).Titular.set(resp, encontrado);
                                } else {
                                    System.out.println("No se encontro al cliente");
                                }
                            }
                        } else {
                            System.out.println("no se encontro cliente");
                        }
                        caso=4;
                        break;
                    case 3:
                        if (banca.get(resp).Titular.size() == 1) {
                            System.out.println("Seguro que deseas desvincular "
                                    + "este cliente de la cuenta?  Si/No");
                            String decision = sn.next();
                            if (decision.equalsIgnoreCase("Si")) {
                                banca.get(resp).Titular.remove(0);
                            } else {
                                System.out.println("Se conservo el mismo titular");
                            }
                        } else {
                            CuentaBancaria.VerCuenta(banca);
                            boolean salir = true;
                            do {
                                System.out.println("Dni del titular a eliminar:");
                                String DNI = sn.next();
                                for (int i = 0; i < banca.get(resp).Titular.size(); i++) {
                                    if (DNI.equalsIgnoreCase(banca.get(resp).Titular.get(i).Dni)) {
                                        banca.get(resp).Titular.remove(i);
                                        salir = false;
                                        break;
                                    }
                                }
                            } while (salir);
                        }
                        caso=4;
                        break;
                    case 4:
                        break;
                }
            } while (caso != 4);

        } else {
            System.out.println("No se encontro la cuenta");
        }
    }

    public static int buscarClienteCuenBanc(ArrayList<CuentaBancaria> banca) {
        Scanner sn = new Scanner(System.in);
        System.out.println("Cual es el dni del titular?");
        String Dni = sn.next();
        int resp = -1;

        for (int i = 0; i < banca.size(); i++) {
            for (int j = 0; j < banca.get(i).Titular.size(); j++) {
                if (banca.get(i).Titular.get(j).Dni.equalsIgnoreCase(Dni)) {

                    resp = i;
                }
            }
        }

        return resp;
    }

    public static void ModificarSaldo(ArrayList<CuentaBancaria> Banca, ArrayList<CuentaCorriente> CCorriente, ArrayList<CuentaAhorros> CAhorros) {
        Scanner sn = new Scanner(System.in);
        System.out.println("Dni de el titular de la cuenta:");
        String respuesta = sn.next();

        for (int i = 0; i < Banca.size(); i++) {
            for (int p = 0; p < Banca.get(i).Titular.size(); p++) {
                if (Banca.get(i).Titular.get(p).Dni.equalsIgnoreCase(respuesta)) {
                    System.out.println("De cuanto es el ingreso?");
                    float ingreso = sn.nextFloat();
                    Banca.get(i).saldo += ingreso;
                }

            }
        }
        for (int i = 0; i < CCorriente.size(); i++) {
            for (int p = 0; p < CCorriente.get(i).Titular.size(); p++) {
                if (CCorriente.get(i).Titular.get(p).Dni.equalsIgnoreCase(respuesta)) {
                    System.out.println("De cuanto es el ingreso?");
                    float ingreso = sn.nextFloat();
                    CCorriente.get(i).setSaldo(ingreso);
                }

            }
        }
        for (int i = 0; i < CAhorros.size(); i++) {
            for (int p = 0; p < CAhorros.get(i).Titular.size(); p++) {
                if (CAhorros.get(i).Titular.get(p).Dni.equalsIgnoreCase(respuesta)) {
                    System.out.println("De cuanto es el ingreso?");
                    float ingreso = sn.nextFloat();
                    CAhorros.get(i).setSaldo(ingreso);
                }

            }
        }

    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo += saldo;
    }

}
