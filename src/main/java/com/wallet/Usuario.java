package com.wallet;

public class Usuario {
    private String nombre;
    private CuentaBancaria cuenta;

    public Usuario(String nombre, CuentaBancaria cuenta) {
        this.nombre = nombre;
        this.cuenta = cuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSaldo() {
        return cuenta.getSaldo();
    }

    public void depositar(double cantidad) {
        if (cantidad > 0) {
            cuenta.depositar(cantidad);
            System.out.println("Depósito de $" + cantidad + " realizado correctamente en la cuenta de " + nombre);
        } else {
            System.out.println("Cantidad inválida para depósito.");
        }
    }

    public boolean retirar(double cantidad) {
        if (cantidad > 0) {
            if (cuenta.retirar(cantidad)) {
                System.out.println("Retiro de $" + cantidad + " realizado correctamente de la cuenta de " + nombre);
                return true;
            } else {
                System.out.println("No se pudo realizar el retiro. Saldo insuficiente en la cuenta de " + nombre);
            }
        } else {
            System.out.println("Cantidad inválida para retiro.");
        }
        return false;
    }

    public boolean convertirMoneda(double cantidad, Moneda monedaDestino, double tasaCambio) {
        if (cantidad > 0) {
            if (cuenta.convertirMoneda(cantidad, monedaDestino, tasaCambio)) {
                System.out.println("Conversión de $" + cantidad + " a " + monedaDestino.getNombre() + " realizada correctamente.");
                return true;
            } else {
                System.out.println("No se pudo realizar la conversión. Saldo insuficiente en la cuenta de " + nombre);
            }
        } else {
            System.out.println("Cantidad inválida para conversión.");
        }
        return false;
    }
}
