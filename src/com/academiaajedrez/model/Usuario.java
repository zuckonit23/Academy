package com.academiaajedrez.model;

import java.io.Serializable;

/**
 * Clase abstracta que representa a un usuario del sistema.
 */
public abstract class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Nombre de usuario para iniciar sesión.
     */
    protected String username;

    /**
     * Contraseña del usuario.
     */
    protected String password;

    /**
     * Constructor de la clase Usuario.
     *
     * @param username Nombre de usuario.
     * @param password Contraseña del usuario.
     */
    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Método para iniciar sesión en el sistema.
     */
    public void iniciarSesion() {
        System.out.println("Usuario " + username + " ha iniciado sesión.");
    }

    /**
     * Método para cerrar sesión en el sistema.
     */
    public void cerrarSesion() {
        System.out.println("Usuario " + username + " ha cerrado sesión.");
    }

    // Getters y setters con comentarios

    /**
     * Obtiene el nombre de usuario.
     *
     * @return Nombre de usuario.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Establece el nombre de usuario.
     *
     * @param username Nombre de usuario.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Obtiene la contraseña del usuario.
     *
     * @return Contraseña del usuario.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param password Contraseña del usuario.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
