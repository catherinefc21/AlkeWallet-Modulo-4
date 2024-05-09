package com.wallet;

public class CuentaBancaria {
    private double saldo;
    private Moneda moneda;

    public CuentaBancaria(double saldoInicial, Moneda moneda) {
        this.saldo = saldoInicial;
        this.moneda = moneda;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            return true;
        }
        return false;
    }

    public boolean retirar(double cantidad) {
        if (cantidad > 0 && saldo >= cantidad) {
            saldo -= cantidad;
            return true;
        }
        return false;
    }

    public boolean convertirMoneda(double cantidad, Moneda monedaDestino, double tasaCambio) {
        // Verificar si hay suficiente saldo para la conversión
        if (cantidad <= saldo && cantidad > 0) {
            // Calcular el monto convertido
            double montoConvertido = cantidad * tasaCambio;

            return true; // La conversión fue exitosa
        }
        return false; // No se pudo realizar la conversión
    }
}

