package com.wallet;

import java.util.Scanner;

/**
 * Clase principal que ejecuta la app AlkeWallet.
 * Permite al usuario realizar diversas operaciones como revisar saldo, depositar,
 * retirar y convertir monedas de pesos chilenos a Dólar y/o Euros.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear una instancia de la moneda
        Moneda pesoChileno = new Moneda("CLP");

        // Crear una instancia de la cuenta bancaria
        CuentaBancaria cuenta = new CuentaBancaria(5000, pesoChileno);

        // Crear una instancia de usuario y asociarla con la cuenta bancaria
        Usuario usuario = new Usuario("Pedro", cuenta);

        int opcion;
        do {
            System.out.println("=========================");
            System.out.println("¡Bienvenido " + usuario.getNombre() + " !");
            System.out.println("Menú de operaciones: ");
            System.out.println("=========================");
            System.out.println("1. Revisar saldo");
            System.out.println("2. Realizar depósito");
            System.out.println("3. Realizar retiro");
            System.out.println("4. Convertir a dólares");
            System.out.println("5. Convertir a euros");
            System.out.println("0. Salir");
            System.out.println("=========================");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Saldo disponible: $" + usuario.getCuenta().getSaldo());
                    break;
                case 2:
                    System.out.print("Ingrese la cantidad a depositar: ");
                    double cantidadDeposito = scanner.nextDouble();
                    usuario.getCuenta().depositar(cantidadDeposito);
                    break;
                case 3:
                    System.out.print("Ingrese la cantidad a retirar: ");
                    double cantidadRetiro = scanner.nextDouble();
                    boolean retiroExitoso = usuario.getCuenta().retirar(cantidadRetiro);
                    if (retiroExitoso) {
                        System.out.println("Retiro realizado correctamente.");
                    } else {
                        System.out.println("No se pudo realizar el retiro. Saldo insuficiente.");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese la cantidad a convertir a dólares: ");
                    double cantidadConvertirDolar = scanner.nextDouble();
                    // tasa de cambio de CLP a USD
                    double tasaCambioDolar = 0.0008;
                    usuario.getCuenta().convertirMoneda(cantidadConvertirDolar, new Moneda("USD"), tasaCambioDolar);
                    break;
                case 5:
                    System.out.print("Ingrese la cantidad a convertir a euros: ");
                    double cantidadConvertirEuro = scanner.nextDouble();
                    // tasa de cambio de CLP a EUR
                    double tasaCambioEuro =0.00065;
                    usuario.getCuenta().convertirMoneda(cantidadConvertirEuro, new Moneda("EUR"), tasaCambioEuro);
                    break;
                case 0:
                    System.out.println("Sesión finalizada");
                    break;
                default:
                    System.out.println("Por favor, seleccione una opción válida.");
                    break;
            }
        } while (opcion != 0);

        scanner.close();
    }
}


