package com.academiaajedrez.controller;

import com.academiaajedrez.model.*;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Clase para manejar la persistencia de datos.
 */
public class DataManager {
    private final String DATA_FILE = "usuarios.dat";

    /**
     * Carga los datos de usuarios desde un archivo.
     *
     * @return Lista de usuarios.
     */
    public ArrayList<Usuario> cargarDatos() {
        File archivo = new File(DATA_FILE);
        if (archivo.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
                return (ArrayList<Usuario>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error al cargar los datos: " + e.getMessage());
            }
        }
        // Si no existe el archivo, inicializamos datos de prueba
        return inicializarDatos();
    }

    /**
     * Guarda los datos de usuarios en un archivo.
     *
     * @param usuarios Lista de usuarios a guardar.
     */
    public void guardarDatos(ArrayList<Usuario> usuarios) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(usuarios);
        } catch (IOException e) {
            System.out.println("Error al guardar los datos: " + e.getMessage());
        }
    }

    /**
     * Inicializa datos de prueba.
     *
     * @return Lista de usuarios con datos de prueba.
     */
    private ArrayList<Usuario> inicializarDatos() {
        ArrayList<Usuario> usuarios = new ArrayList<>();

        // Agregar profesores
        Profesor profesor1 = new Profesor("profesor1", "pass123", "Juan Pérez", "juan.perez@example.com", 10);
        Profesor profesor2 = new Profesor("profesor2", "pass456", "María López", "maria.lopez@example.com", 8);

        usuarios.add(profesor1);
        usuarios.add(profesor2);

        // Agregar alumnos
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaIngreso = sdf.parse("01/09/2023");

            Alumno alumno1 = new Alumno("alumno1", "alumno123", "Carlos Sánchez", 20, 1500, 1600, fechaIngreso);
            alumno1.setAprobado(true);

            Alumno alumno2 = new Alumno("alumno2", "alumno456", "Laura Gómez", 22, 1400, 1500, fechaIngreso);
            alumno2.setAprobado(true);

            Alumno alumno3 = new Alumno("alumno3", "alumno789", "Miguel Torres", 18, 1300, 1400, fechaIngreso);
            // En espera de aprobación

            Alumno alumno4 = new Alumno("alumno4", "alumno012", "Ana Ruiz", 25, 1600, 1700, fechaIngreso);
            // En espera de aprobación

            Alumno alumno5 = new Alumno("alumno5", "alumno345", "Diego Fernández", 19, 1200, 1300, fechaIngreso);
            // En espera de aprobación

            usuarios.add(alumno1);
            usuarios.add(alumno2);
            usuarios.add(alumno3);
            usuarios.add(alumno4);
            usuarios.add(alumno5);
        } catch (ParseException e) {
            System.out.println("Error al parsear la fecha de ingreso.");
        }

        return usuarios;
    }
}

