package com.wallet;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear una cuenta bancaria en pesos chilenos
        Moneda pesoChileno = new Moneda("CLP", "Peso Chileno");
        CuentaBancaria cuenta = new CuentaBancaria(5000, pesoChileno);
        Usuario usuario = new Usuario("Pedro", cuenta);

        int opcion;
        do {
            System.out.println("\nMenú de opciones:");
            System.out.println("1. Revisar saldo");
            System.out.println("2. Realizar depósito");
            System.out.println("3. Realizar retiro");
            System.out.println("4. Convertir a dólares");
            System.out.println("5. Convertir a euros");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Saldo disponible: $" + usuario.getSaldo());
                    break;
                case 2:
                    System.out.print("Ingrese la cantidad a depositar: ");
                    double cantidadDeposito = scanner.nextDouble();
                    usuario.depositar(cantidadDeposito);
                    System.out.println("Depósito realizado correctamente.");
                    break;
                case 3:
                    System.out.print("Ingrese la cantidad a retirar: ");
                    double cantidadRetiro = scanner.nextDouble();
                    boolean retiroExitoso = usuario.retirar(cantidadRetiro);
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
                    double tasaCambioDolar = 0.001;
                    boolean conversionExitosaDolar = usuario.convertirMoneda(cantidadConvertirDolar, new Moneda("USD", "Dólar"), tasaCambioDolar);
                    if (conversionExitosaDolar) {
                        System.out.println("Conversión a dólares realizada correctamente.");
                    } else {
                        System.out.println("No se pudo realizar la conversión a dólares. Saldo insuficiente.");
                    }
                    break;
                case 5:
                    System.out.print("Ingrese la cantidad a convertir a euros: ");
                    double cantidadConvertirEuro = scanner.nextDouble();
                    // tasa de cambio de CLP a EUR
                    double tasaCambioEuro = 0.0008;
                    boolean conversionExitosaEuro = usuario.convertirMoneda(cantidadConvertirEuro, new Moneda("EUR", "Euro"), tasaCambioEuro);
                    if (conversionExitosaEuro) {
                        System.out.println("Conversión a euros realizada correctamente.");
                    } else {
                        System.out.println("No se pudo realizar la conversión a euros. Saldo insuficiente.");
                    }
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


