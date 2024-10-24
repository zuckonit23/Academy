package com.academiaajedrez.view;

import com.academiaajedrez.controller.UsuarioController;

import java.util.Scanner;

/**
 * Clase principal que muestra el menú inicial del sistema.
 */
public class MainView {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UsuarioController usuarioController = new UsuarioController();
        int opcion = 0;

        do {
            System.out.println("\n=== Sistema de Gestión de Academia de Ajedrez ===");
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Registrar nuevo alumno");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        usuarioController.iniciarSesion(scanner);
                        break;
                    case 2:
                        usuarioController.registrarNuevoAlumno(scanner);
                        break;
                    case 3:
                        System.out.println("Gracias por utilizar el sistema. ¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, seleccione entre 1 y 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número entre 1 y 3.");
            }
        } while (opcion != 3);

        scanner.close();
    }
}
