package com.academiaajedrez.view;

import com.academiaajedrez.controller.ProfesorController;
import com.academiaajedrez.model.Profesor;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase que maneja la interfaz de usuario para los profesores.
 */
public class ProfesorView {
    private Profesor profesor;
    private ProfesorController profesorController;

    /**
     * Constructor de la vista de profesor.
     *
     * @param profesor      Profesor que ha iniciado sesión.
     * @param usuarios      Lista de usuarios.
     * @param dataManager   Gestor de datos.
     */
    public ProfesorView(Profesor profesor, ArrayList<com.academiaajedrez.model.Usuario> usuarios, com.academiaajedrez.controller.DataManager dataManager) {
        this.profesor = profesor;
        this.profesorController = new ProfesorController(usuarios, dataManager);
    }

    /**
     * Muestra el menú específico para profesores.
     *
     * @param scanner Objeto Scanner para leer entradas del usuario.
     */
    public void mostrarMenuProfesor(Scanner scanner) {
        int opcion = 0;

        do {
            System.out.println("\n--- Menú Profesor ---");
            System.out.println("1. Ver alumnos en espera de aprobación");
            System.out.println("2. Aprobar alumno");
            System.out.println("3. Cerrar sesión");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        profesorController.verAlumnosEnEspera();
                        break;
                    case 2:
                        profesorController.aprobarAlumno(scanner, profesor);
                        break;
                    case 3:
                        System.out.println("Cerrando sesión...");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, seleccione entre 1 y 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número entre 1 y 3.");
            }
        } while (opcion != 3);
    }
}
