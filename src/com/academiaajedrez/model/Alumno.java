package com.academiaajedrez.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * Clase que representa a un alumno en el sistema.
 */
public class Alumno extends Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Nombre completo del alumno.
     */
    private String nombreCompleto;

    /**
     * ID único del alumno.
     */
    private UUID idAlumno;

    /**
     * Edad del alumno.
     */
    private int edad;

    /**
     * Elo FIDE del alumno.
     */
    private int eloFIDE;

    /**
     * Elo virtual del alumno.
     */
    private int eloVirtual;

    /**
     * Fecha de ingreso del alumno.
     */
    private Date fechaIngreso;

    /**
     * Indica si el alumno ha sido aprobado.
     */
    private boolean aprobado;

    /**
     * Constructor de la clase Alumno.
     *
     * @param username       Nombre de usuario.
     * @param password       Contraseña.
     * @param nombreCompleto Nombre completo.
     * @param edad           Edad.
     * @param eloFIDE        Elo FIDE.
     * @param eloVirtual     Elo virtual.
     * @param fechaIngreso   Fecha de ingreso.
     */
    public Alumno(String username, String password, String nombreCompleto, int edad, int eloFIDE, int eloVirtual, Date fechaIngreso) {
        super(username, password);
        this.idAlumno = UUID.randomUUID(); // Generación automática de ID
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
        this.eloFIDE = eloFIDE;
        this.eloVirtual = eloVirtual;
        this.fechaIngreso = fechaIngreso;
        this.aprobado = false; // Por defecto, no está aprobado
    }

    // Getters y setters con comentarios

    /**
     * Obtiene el nombre completo del alumno.
     *
     * @return Nombre completo del alumno.
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * Establece el nombre completo del alumno.
     *
     * @param nombreCompleto Nombre completo.
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    /**
     * Obtiene el ID único del alumno.
     *
     * @return ID del alumno.
     */
    public UUID getIdAlumno() {
        return idAlumno;
    }

    /**
     * Establece el ID único del alumno.
     *
     * @param idAlumno ID del alumno.
     */
    public void setIdAlumno(UUID idAlumno) {
        this.idAlumno = idAlumno;
    }

    /**
     * Obtiene la edad del alumno.
     *
     * @return Edad del alumno.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Establece la edad del alumno.
     *
     * @param edad Edad del alumno.
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Obtiene el Elo FIDE del alumno.
     *
     * @return Elo FIDE del alumno.
     */
    public int getEloFIDE() {
        return eloFIDE;
    }

    /**
     * Establece el Elo FIDE del alumno.
     *
     * @param eloFIDE Elo FIDE del alumno.
     */
    public void setEloFIDE(int eloFIDE) {
        this.eloFIDE = eloFIDE;
    }

    /**
     * Obtiene el Elo virtual del alumno.
     *
     * @return Elo virtual del alumno.
     */
    public int getEloVirtual() {
        return eloVirtual;
    }

    /**
     * Establece el Elo virtual del alumno.
     *
     * @param eloVirtual Elo virtual del alumno.
     */
    public void setEloVirtual(int eloVirtual) {
        this.eloVirtual = eloVirtual;
    }

    /**
     * Obtiene la fecha de ingreso del alumno.
     *
     * @return Fecha de ingreso del alumno.
     */
    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    /**
     * Establece la fecha de ingreso del alumno.
     *
     * @param fechaIngreso Fecha de ingreso del alumno.
     */
    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    /**
     * Verifica si el alumno ha sido aprobado.
     *
     * @return true si ha sido aprobado, false en caso contrario.
     */
    public boolean isAprobado() {
        return aprobado;
    }

    /**
     * Establece el estado de aprobación del alumno.
     *
     * @param aprobado Estado de aprobación.
     */
    public void setAprobado(boolean aprobado) {
        this.aprobado = aprobado;
    }
}
