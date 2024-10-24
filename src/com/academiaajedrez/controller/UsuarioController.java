package com.academiaajedrez.controller;

import com.academiaajedrez.exceptions.EntradaInvalidaException;
import com.academiaajedrez.exceptions.UsuarioExistenteException;
import com.academiaajedrez.exceptions.UsuarioNoEncontradoException;
import com.academiaajedrez.model.Alumno;
import com.academiaajedrez.model.Usuario;
import com.academiaajedrez.model.Profesor;
import com.academiaajedrez.view.AlumnoView;
import com.academiaajedrez.view.ProfesorView;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Controlador para manejar las acciones relacionadas con los usuarios.
 */
public class UsuarioController {
    private ArrayList<Usuario> usuarios;
    private DataManager dataManager;

    /**
     * Constructor del controlador de usuarios.
     */
    public UsuarioController() {
        dataManager = new DataManager();
        usuarios = dataManager.cargarDatos();
    }

    /**
     * Permite al usuario iniciar sesión en el sistema.
     *
     * @param scanner Objeto Scanner para leer entradas del usuario.
     */
    public void iniciarSesion(Scanner scanner) {
        try {
            System.out.print("Ingrese su nombre de usuario: ");
            String username = scanner.nextLine();
            System.out.print("Ingrese su contraseña: ");
            String password = scanner.nextLine();

            Usuario usuario = autenticarUsuario(username, password);

            System.out.println("¡Inicio de sesión exitoso!");

            if (usuario instanceof Profesor) {
                ProfesorView profesorView = new ProfesorView((Profesor) usuario, usuarios, dataManager);
                profesorView.mostrarMenuProfesor(scanner);
            } else if (usuario instanceof Alumno) {
                Alumno alumno = (Alumno) usuario;
                if (alumno.isAprobado()) {
                    AlumnoView alumnoView = new AlumnoView(alumno);
                    alumnoView.mostrarMenuAlumno(scanner);
                } else {
                    System.out.println("Su registro está en espera de aprobación por parte de un profesor.");
                }
            }
        } catch (UsuarioNoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Autentica al usuario con el nombre de usuario y contraseña proporcionados.
     *
     * @param username Nombre de usuario.
     * @param password Contraseña.
     * @return Objeto Usuario si las credenciales son correctas.
     * @throws UsuarioNoEncontradoException Si no se encuentra el usuario o las credenciales son incorrectas.
     */
    private Usuario autenticarUsuario(String username, String password) throws UsuarioNoEncontradoException {
        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(username) && usuario.getPassword().equals(password)) {
                return usuario;
            }
        }
        throw new UsuarioNoEncontradoException("Credenciales incorrectas. Por favor, verifique su nombre de usuario y contraseña.");
    }

    /**
     * Permite registrar un nuevo alumno en el sistema.
     *
     * @param scanner Objeto Scanner para leer entradas del usuario.
     */
    public void registrarNuevoAlumno(Scanner scanner) {
        try {
            String username;
            do {
                username = solicitarString("Ingrese su nombre de usuario: ", scanner);
                if (usuarioExiste(username)) {
                    throw new UsuarioExistenteException("El nombre de usuario '" + username + "' ya está en uso. Por favor, elija otro.");
                } else {
                    break;
                }
            } while (true);

            String password = solicitarString("Ingrese una contraseña: ", scanner);
            String nombreCompleto = solicitarString("Ingrese su nombre completo: ", scanner);
            int edad = solicitarInt("Ingrese su edad: ", scanner);
            int eloFIDE = solicitarInt("Ingrese su Elo FIDE: ", scanner);
            int eloVirtual = solicitarInt("Ingrese su Elo Virtual: ", scanner);

            Date fechaIngreso = new Date();
            Alumno nuevoAlumno = new Alumno(username, password, nombreCompleto, edad, eloFIDE, eloVirtual, fechaIngreso);
            usuarios.add(nuevoAlumno);

            System.out.println("Registro exitoso. Su cuenta está en espera de aprobación por parte de un profesor.");
            dataManager.guardarDatos(usuarios);
        } catch (UsuarioExistenteException | EntradaInvalidaException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Solicita una entrada de tipo String al usuario.
     *
     * @param mensaje Mensaje a mostrar al usuario.
     * @param scanner Objeto Scanner para leer entradas del usuario.
     * @return Cadena ingresada por el usuario.
     * @throws EntradaInvalidaException Si la entrada es inválida.
     */
    private String solicitarString(String mensaje, Scanner scanner) throws EntradaInvalidaException {
        String input;
        do {
            System.out.print(mensaje);
            input = scanner.nextLine();
            input = sanitizarEntrada(input);
            if (input.isEmpty()) {
                throw new EntradaInvalidaException("La entrada no puede estar vacía. Intente nuevamente.");
            } else {
                break;
            }
        } while (true);
        return input;
    }

    /**
     * Solicita una entrada de tipo int al usuario.
     *
     * @param mensaje Mensaje a mostrar al usuario.
     * @param scanner Objeto Scanner para leer entradas del usuario.
     * @return Entero ingresado por el usuario.
     * @throws EntradaInvalidaException Si la entrada es inválida.
     */
    private int solicitarInt(String mensaje, Scanner scanner) throws EntradaInvalidaException {
        int numero;
        do {
            System.out.print(mensaje);
            try {
                numero = Integer.parseInt(scanner.nextLine());
                if (numero <= 0) {
                    throw new EntradaInvalidaException("El número debe ser positivo y mayor que cero. Intente nuevamente.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                throw new EntradaInvalidaException("Entrada inválida. Por favor, ingrese un número válido.");
            }
        } while (true);
        return numero;
    }

    /**
     * Verifica si un nombre de usuario ya existe en el sistema.
     *
     * @param username Nombre de usuario a verificar.
     * @return true si el usuario existe, false en caso contrario.
     */
    private boolean usuarioExiste(String username) {
        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equalsIgnoreCase(username)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Sanitiza una entrada de texto eliminando caracteres especiales.
     *
     * @param input Entrada a sanitizar.
     * @return Entrada sanitizada.
     */
    private String sanitizarEntrada(String input) {
        return input.replaceAll("[<>\"'%;()&+]", "").trim();
    }
}
