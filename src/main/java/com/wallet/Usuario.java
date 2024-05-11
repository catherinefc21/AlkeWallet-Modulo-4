package com.wallet;

/**
 * Clase que representa un usuario de la Wallet.
 * Cada usuario tiene un nombre y una cuenta bancaria asociada.
 */
public class Usuario {
    private String nombre;
    private CuentaBancaria cuenta;

    /**
     * Constructor para crear un nuevo usuario con un nombre y una cuenta bancaria asociada.
     * @param nombre El nombre del usuario.
     * @param cuenta La cuenta bancaria asociada al usuario.
     */
    public Usuario(String nombre, CuentaBancaria cuenta) {
        this.nombre = nombre;
        this.cuenta = cuenta;
    }

    /**
     * Obtiene la cuenta bancaria asociada al usuario.
     * @return La cuenta bancaria asociada al usuario.
     */
    public CuentaBancaria getCuenta() {
        return cuenta;
    }

    /**
     * Obtiene el nombre del usuario.
     * @return El nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }
}
