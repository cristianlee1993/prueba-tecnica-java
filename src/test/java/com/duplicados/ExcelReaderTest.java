package com.duplicados;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase ExcelReader.
 * Verifica que los contactos se lean correctamente desde un archivo Excel.
 */
public class ExcelReaderTest {

    /**
     * Prueba que verifica que el método leerContactos funcione correctamente.
     * Comprueba que:
     * - La lista de contactos no sea nula.
     * - La lista contenga al menos un contacto.
     * - Los campos principales del primer contacto se hayan leído correctamente.
     */
    @Test
    void testLeerContactos() throws IOException {
        // Nombre del archivo tal como está en resources
        String archivo = "contactos.xlsx";

        // Llamada al método para leer contactos desde Excel
        List<Contacto> contactos = ExcelReader.leerContactos(archivo);

        // Verificar que la lista no sea nula
        assertNotNull(contactos);

        // Verificar que la lista contenga al menos un contacto
        assertFalse(contactos.isEmpty());

        // Verificar que los campos principales del primer contacto se hayan leído correctamente
        Contacto primerContacto = contactos.get(0);
        assertNotNull(primerContacto.getNombre());
        assertNotNull(primerContacto.getApellido());
        assertNotNull(primerContacto.getEmail());
        assertNotNull(primerContacto.getCodigoPostal());

        // Información adicional en consola para depuración
        System.out.println("Número de contactos leídos: " + contactos.size());
        System.out.println("Primer contacto: " + primerContacto.getNombre() + " " + primerContacto.getApellido());
    }
}
