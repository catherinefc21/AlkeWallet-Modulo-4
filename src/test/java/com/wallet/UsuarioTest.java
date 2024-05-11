package com.wallet;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class UsuarioTest {

    @Test
    public void testGetCuenta() {

        Moneda moneda = new Moneda("USD");
        CuentaBancaria cuenta = new CuentaBancaria(1000, moneda);
        Usuario usuario = new Usuario("José", cuenta);

        // Verificar que la cuenta obtenida sea la misma que la cuenta creada
        assertEquals(cuenta, usuario.getCuenta());
    }

    @Test
    public void testGetNombre() {

        Usuario usuario = new Usuario("Ana", null);

        // Verificar que el nombre obtenido sea el mismo que el nombre creado
        assertEquals("Ana", usuario.getNombre());
    }
}
