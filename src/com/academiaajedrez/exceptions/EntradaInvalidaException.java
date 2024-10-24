package com.academiaajedrez.exceptions;

/**
 * Excepción lanzada cuando una entrada proporcionada por el usuario es inválida.
 */
public class EntradaInvalidaException extends Exception {
    public EntradaInvalidaException(String mensaje) {
        super(mensaje);
    }
}
