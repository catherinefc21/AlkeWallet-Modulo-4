package com.wallet;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MonedaTest {

    @Test
    public void testGetCodigoISO() {

        Moneda moneda = new Moneda("EUR");

        // Verificar que el código ISO obtenido sea el mismo que el código ISO creado
        assertEquals("EUR", moneda.getCodigoISO());
    }
}
