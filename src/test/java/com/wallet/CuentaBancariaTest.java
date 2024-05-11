package com.wallet;

import static org.junit.Assert.*;
import org.junit.Test;

public class CuentaBancariaTest {

    @Test
    public void testGetSaldo() {

        Moneda moneda = new Moneda("USD");
        CuentaBancaria cuenta = new CuentaBancaria(1000, moneda);

        // Verificar que el saldo obtenido sea el mismo que el saldo inicial
        assertEquals(1000, cuenta.getSaldo(), 0.001);
    }

    @Test
    public void testDepositar() {

        Moneda moneda = new Moneda("USD");
        CuentaBancaria cuenta = new CuentaBancaria(500, moneda);

        // Realizar un depósito de $100
        assertTrue(cuenta.depositar(100));

        // Verificar que el nuevo saldo sea $600
        assertEquals(600, cuenta.getSaldo(), 0.001);
    }

    @Test
    public void testRetirar() {

        Moneda moneda = new Moneda("USD");
        CuentaBancaria cuenta = new CuentaBancaria(1000, moneda);

        // Realizar un retiro de $200
        assertTrue(cuenta.retirar(200));

        // Verificar que el nuevo saldo sea $800
        assertEquals(800, cuenta.getSaldo(), 0.001);
    }

    @Test
    public void testConvertirMoneda() {

        Moneda pesoChileno = new Moneda("CLP");
        double tasaCambioDolar = 0.0008;

        CuentaBancaria cuentaPrueba = new CuentaBancaria(5000, pesoChileno);

        // Convertir $1000 a dolar
        assertTrue(cuentaPrueba.convertirMoneda(1000, new Moneda("EUR"), tasaCambioDolar));
    }
}
