package com.wallet;

/**
 * Clase que representa una moneda.
 * Permite obtener el código ISO de la moneda.
 */
public class Moneda {
    private String codigoISO;

    /**
     * Constructor para crear una nueva instancia de moneda con un código ISO específico.
     * @param codigoISO de la moneda.
     */
    public Moneda(String codigoISO) {
        this.codigoISO = codigoISO;
    }

    /**
     * Obtiene el código ISO de la moneda.
     * @return El código ISO de la moneda.
     */
    public String getCodigoISO() {
        return codigoISO;
    }
}
