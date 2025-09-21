package com.duplicados;

/**
 * Clase que representa un contacto con información básica.
 * Cada contacto tiene un id único y datos personales como nombre, apellido,
 * correo electrónico, código postal y dirección.
 */
public class Contacto {
    // Identificador único del contacto
    private int id;

    // Nombre del contacto
    private String nombre;

    // Apellido del contacto
    private String apellido;

    // Correo electrónico del contacto
    private String email;

    // Código postal del contacto
    private String codigoPostal;

    // Dirección física del contacto (opcional)
    private String direccion;

    /**
     * Constructor de la clase Contacto.
     *
     * @param id Identificador único del contacto
     * @param nombre Nombre del contacto
     * @param apellido Apellido del contacto
     * @param email Correo electrónico del contacto
     * @param codigoPostal Código postal del contacto
     * @param direccion Dirección física del contacto
     */
    public Contacto(int id, String nombre, String apellido, String email, String codigoPostal, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.codigoPostal = codigoPostal;
        this.direccion = direccion;
    }

    // Getters (métodos para obtener los valores de cada atributo)
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getEmail() { return email; }
    public String getCodigoPostal() { return codigoPostal; }
    public String getDireccion() { return direccion; }

    // Si deseas, se pueden agregar setters para modificar los valores de los atributos
}
