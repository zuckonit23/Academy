package com.academiaajedrez.controller;

import com.academiaajedrez.model.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Controlador para manejar las acciones relacionadas con los profesores.
 */
public class ProfesorController {
    private ArrayList<Usuario> usuarios;
    private DataManager dataManager;

    /**
     * Constructor del controlador de profesores.
     *
     * @param usuarios    Lista de usuarios.
     * @param dataManager Gestor de datos.
     */
    public ProfesorController(ArrayList<Usuario> usuarios, DataManager dataManager) {
        this.usuarios = usuarios;
        this.dataManager = dataManager;
    }

    /**
     * Muestra la lista de alumnos en espera de aprobación.
     */
    public void verAlumnosEnEspera() {
        ArrayList<Alumno> enEspera = obtenerAlumnosEnEspera();
        if (enEspera.isEmpty()) {
            System.out.println("No hay alumnos en espera de aprobación.");
        } else {
            System.out.println("Alumnos en espera de aprobación:");
            for (int i = 0; i < enEspera.size(); i++) {
                Alumno alumno = enEspera.get(i);
                System.out.println((i + 1) + ". " + alumno.getNombreCompleto() + " (ID: " + alumno.getIdAlumno() + ")");
            }
        }
    }

    /**
     * Permite al profesor aprobar a un alumno en espera.
     *
     * @param scanner  Objeto Scanner para leer entradas del usuario.
     * @param profesor Profesor que aprueba al alumno.
     */
    public void aprobarAlumno(Scanner scanner, Profesor profesor) {
        ArrayList<Alumno> enEspera = obtenerAlumnosEnEspera();
        if (enEspera.isEmpty()) {
            System.out.println("No hay alumnos para aprobar.");
            return;
        }

        verAlumnosEnEspera();

        System.out.print("Seleccione el número del alumno que desea aprobar: ");
        try {
            int opcion = Integer.parseInt(scanner.nextLine());
            if (opcion > 0 && opcion <= enEspera.size()) {
                Alumno alumnoAprobado = enEspera.get(opcion - 1);
                profesor.aprobarAlumno(alumnoAprobado);
                dataManager.guardarDatos(usuarios);
            } else {
                System.out.println("Opción inválida. Por favor, seleccione un número válido de la lista.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Por favor, ingrese un número válido.");
        }
    }

    /**
     * Obtiene la lista de alumnos en espera de aprobación.
     *
     * @return Lista de alumnos en espera.
     */
    private ArrayList<Alumno> obtenerAlumnosEnEspera() {
        ArrayList<Alumno> enEspera = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            if (usuario instanceof Alumno) {
                Alumno alumno = (Alumno) usuario;
                if (!alumno.isAprobado()) {
                    enEspera.add(alumno);
                }
            }
        }
        return enEspera;
    }
}
