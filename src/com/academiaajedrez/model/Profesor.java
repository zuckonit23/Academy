package com.academiaajedrez.model;

import java.util.UUID;

/**
 * Clase que representa a un profesor en el sistema.
 */
public class Profesor extends Usuario {
    private static final long serialVersionUID = 1L;

    /**
     * Nombre completo del profesor.
     */
    private String nombreCompleto;

    /**
     * ID único del profesor.
     */
    private UUID idProfesor;

    /**
     * Correo electrónico del profesor.
     */
    private String correoElectronico;

    /**
     * Años de experiencia del profesor.
     */
    private int experiencia;

    /**
     * Constructor de la clase Profesor.
     *
     * @param username        Nombre de usuario.
     * @param password        Contraseña.
     * @param nombreCompleto  Nombre completo.
     * @param correoElectronico Correo electrónico.
     * @param experiencia     Años de experiencia.
     */
    public Profesor(String username, String password, String nombreCompleto, String correoElectronico, int experiencia) {
        super(username, password);
        this.idProfesor = UUID.randomUUID(); // Generación automática de ID
        this.nombreCompleto = nombreCompleto;
        this.correoElectronico = correoElectronico;
        this.experiencia = experiencia;
    }

    /**
     * Método para aprobar a un alumno.
     *
     * @param alumno Alumno a aprobar.
     */
    public void aprobarAlumno(Alumno alumno) {
        alumno.setAprobado(true);
        System.out.println("El alumno " + alumno.getNombreCompleto() + " ha sido aprobado por el profesor " + nombreCompleto + ".");
    }

    // Getters y setters con comentarios

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public UUID getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(UUID idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }
}
