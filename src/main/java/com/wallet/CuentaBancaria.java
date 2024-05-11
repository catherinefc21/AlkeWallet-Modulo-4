package com.wallet;

/**
 * Clase que representa una cuenta bancaria.
 * Permite realizar operaciones como depósitos, retiros y conversiones de moneda.
 */
public class CuentaBancaria {
    private double saldo;
    Moneda moneda;

    /**
     * Constructor para crear una nueva cuenta bancaria con un saldo inicial y una moneda específica.
     * @param saldoInicial
     * @param moneda La moneda en la que está denominada la cuenta.
     */
    public CuentaBancaria(double saldoInicial, Moneda moneda) {
        this.saldo = saldoInicial;
        this.moneda = moneda;
    }

    /**
     * Obtiene el saldo actual de la cuenta.
     * @return El saldo actual de la cuenta.
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Realiza un depósito en la cuenta.
     * @param cantidad La cantidad a depositar.
     * @return true si el depósito se realizó con éxito, false si la cantidad es negativa.
     */
    public boolean depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            System.out.println("El nuevo saldo es de " + "$" + saldo);
            return true;
        }
        return false;
    }

    /**
     * Realiza un retiro de la cuenta.
     * @param cantidad La cantidad a retirar.
     * @return true si el retiro se realizó con éxito, false si la cantidad es negativa o el saldo es insuficiente.
     */
    public boolean retirar(double cantidad) {
        if (cantidad > 0 && saldo >= cantidad) {
            saldo -= cantidad;
            System.out.println("El nuevo saldo es de " + "$" + saldo);
            return true;
        }
        return false;
    }

    /**
     * Convierte una cantidad de dinero a una moneda específica.
     * @param cantidad La cantidad a convertir.
     * @param moneda La moneda a la que se va a convertir.
     * @param tasaCambio La tasa de cambio para la conversión.
     * @return true si la conversión se realizó con éxito, false si la cantidad es negativa, el saldo es insuficiente o la tasa de cambio es inválida.
     */
    public boolean convertirMoneda(double cantidad, Moneda moneda, double tasaCambio) {
        // Verificar si hay suficiente saldo para la conversión
        if (cantidad <= saldo && cantidad > 0 && tasaCambio > 0) {
            // Calcular el monto convertido
            double montoConvertido = cantidad * tasaCambio;
            System.out.println("Conversión de $" + cantidad + " a " + montoConvertido + " " + moneda.getCodigoISO() + " realizada correctamente.");
            return true; // La conversión fue exitosa
        }
        return false; // No se pudo realizar la conversión
    }
}
