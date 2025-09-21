package com.duplicados;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase DuplicadosDetector.
 * Se prueban diferentes escenarios de coincidencias entre contactos:
 * - Coincidencia por email (Alta)
 * - Coincidencia por código postal (Baja)
 * - Sin coincidencias
 * - Varios contactos con combinaciones de coincidencias
 */
public class DuplicadosDetectorTest {

    /**
     * Verifica que se detecte una coincidencia de "Alta" cuando dos contactos tienen el mismo email.
     */
    @Test
    void testEncontrarDuplicados_EmailIgual() {
        List<Contacto> contactos = new ArrayList<>();
        contactos.add(new Contacto(1, "Juan", "Perez", "juan@mail.com", "12345", "Calle 1"));
        contactos.add(new Contacto(2, "Juan", "Lopez", "juan@mail.com", "67890", "Calle 2"));

        List<DuplicadosDetector.Coincidencia> duplicados = DuplicadosDetector.encontrarDuplicados(contactos);

        // Debe existir una coincidencia
        assertEquals(1, duplicados.size());

        // La precisión debe ser "Alta" porque los emails son iguales
        assertEquals("Alta", duplicados.get(0).precision);
    }

    /**
     * Verifica que se detecte una coincidencia de "Baja" cuando dos contactos tienen el mismo código postal.
     */
    @Test
    void testEncontrarDuplicados_CodigoPostalIgual() {
        List<Contacto> contactos = new ArrayList<>();
        contactos.add(new Contacto(1, "Ana", "Gomez", "ana1@mail.com", "54321", "Calle 3"));
        contactos.add(new Contacto(2, "Ana", "Gomez", "ana2@mail.com", "54321", "Calle 4"));

        List<DuplicadosDetector.Coincidencia> duplicados = DuplicadosDetector.encontrarDuplicados(contactos);

        // Debe existir una coincidencia
        assertEquals(1, duplicados.size());

        // La precisión debe ser "Baja" porque los códigos postales son iguales
        assertEquals("Baja", duplicados.get(0).precision);
    }

    /**
     * Verifica que no se detecten coincidencias cuando los contactos no tienen ni email ni código postal iguales.
     */
    @Test
    void testEncontrarDuplicados_SinCoincidencias() {
        List<Contacto> contactos = new ArrayList<>();
        contactos.add(new Contacto(1, "Pedro", "Sanchez", "pedro1@mail.com", "11111", "Calle 5"));
        contactos.add(new Contacto(2, "Luis", "Ramirez", "luis@mail.com", "22222", "Calle 6"));

        List<DuplicadosDetector.Coincidencia> duplicados = DuplicadosDetector.encontrarDuplicados(contactos);

        // La lista de duplicados debe estar vacía
        assertTrue(duplicados.isEmpty());
    }

    /**
     * Verifica un escenario con varios contactos y diferentes tipos de coincidencias.
     * Se espera:
     * - Coincidencia "Baja" por código postal entre contacto 1 y 2
     * - Coincidencia "Alta" por email entre contacto 1 y 3
     */
    @Test
    void testEncontrarDuplicados_VariosContactos() {
        List<Contacto> contactos = new ArrayList<>();
        contactos.add(new Contacto(1, "Juan", "Perez", "juan@mail.com", "12345", "Calle 1"));
        contactos.add(new Contacto(2, "Ana", "Lopez", "ana@mail.com", "12345", "Calle 2"));
        contactos.add(new Contacto(3, "Juan", "Perez", "juan@mail.com", "67890", "Calle 3"));

        List<DuplicadosDetector.Coincidencia> duplicados = DuplicadosDetector.encontrarDuplicados(contactos);

        // Solo habrá 2 coincidencias válidas
        assertEquals(2, duplicados.size());

        // Verificar precisión de cada coincidencia
        assertEquals("Baja", duplicados.get(0).precision);  // contacto 1 vs 2
        assertEquals("Alta", duplicados.get(1).precision);  // contacto 1 vs 3
    }
}
