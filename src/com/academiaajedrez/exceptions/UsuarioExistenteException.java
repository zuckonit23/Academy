package com.academiaajedrez.exceptions;

/**
 * Excepción lanzada cuando se intenta registrar un nombre de usuario ya existente.
 */
public class UsuarioExistenteException extends Exception {
    public UsuarioExistenteException(String mensaje) {
        super(mensaje);
    }
}
