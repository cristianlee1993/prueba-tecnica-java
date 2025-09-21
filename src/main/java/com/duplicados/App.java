package com.duplicados;

import java.io.IOException;
import java.util.List;

/**
 * Clase principal de la aplicación para detectar contactos duplicados.
 * Esta clase lee los contactos desde un archivo Excel, encuentra duplicados
 * usando DuplicadosDetector y muestra los resultados en la consola.
 */
public class App
{
    public static void main(String[] args) throws IOException {
        // Leer contactos desde el archivo Excel
        List<Contacto> contactos = ExcelReader.leerContactos("contactos.xlsx");

        // Encontrar duplicados entre los contactos
        List<DuplicadosDetector.Coincidencia> duplicados = DuplicadosDetector.encontrarDuplicados(contactos);

        // Separador para mejorar la presentación en consola
        String separador = "------------------------------------------------------------------";

        // Imprimir encabezado de la tabla
        System.out.println(separador);
        System.out.printf("%-20s | %-25s | %-10s%n", "ContactoID Origen", "ContactoID Coincidencia", "Precisión");
        System.out.println(separador);

        // Imprimir cada coincidencia detectada
        for (DuplicadosDetector.Coincidencia c : duplicados) {
            System.out.printf("%-20d | %-25d | %-10s%n", c.idOrigen, c.idCoincide, c.precision);
        }

        System.out.println(separador);

    }
}
