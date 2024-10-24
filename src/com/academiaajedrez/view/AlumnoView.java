package com.academiaajedrez.view;

import com.academiaajedrez.model.Alumno;

import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * Clase que maneja la interfaz de usuario para los alumnos.
 */
public class AlumnoView {
    private Alumno alumno;

    /**
     * Constructor de la vista de alumno.
     *
     * @param alumno Alumno que ha iniciado sesión.
     */
    public AlumnoView(Alumno alumno) {
        this.alumno = alumno;
    }

    /**
     * Muestra el menú específico para alumnos.
     *
     * @param scanner Objeto Scanner para leer entradas del usuario.
     */
    public void mostrarMenuAlumno(Scanner scanner) {
        int opcion = 0;

        do {
            System.out.println("\n--- Menú Alumno ---");
            System.out.println("1. Ver perfil");
            System.out.println("2. Cerrar sesión");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        verPerfilAlumno();
                        break;
                    case 2:
                        System.out.println("Cerrando sesión...");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, seleccione entre 1 y 2.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingrese 1 o 2.");
            }
        } while (opcion != 2);
    }

    /**
     * Muestra el perfil del alumno.
     */
    private void verPerfilAlumno() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("\n--- Perfil del Alumno ---");
        System.out.println("Nombre: " + alumno.getNombreCompleto());
        System.out.println("ID: " + alumno.getIdAlumno());
        System.out.println("Edad: " + alumno.getEdad());
        System.out.println("Elo FIDE: " + alumno.getEloFIDE());
        System.out.println("Elo Virtual: " + alumno.getEloVirtual());
        System.out.println("Fecha de Ingreso: " + sdf.format(alumno.getFechaIngreso()));
    }
}
