package com.academiaajedrez.exceptions;

/**
 * Excepción lanzada cuando no se encuentra un usuario con las credenciales proporcionadas.
 */
public class UsuarioNoEncontradoException extends Exception {
    public UsuarioNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}
