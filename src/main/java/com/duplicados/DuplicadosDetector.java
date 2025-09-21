package com.duplicados;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase responsable de detectar contactos duplicados en una lista de contactos.
 * Utiliza criterios simples para determinar el nivel de coincidencia:
 * - Alta: coincidencia exacta de email
 * - Baja: coincidencia de código postal
 * - Ninguna: no hay coincidencia relevante
 */
public class DuplicadosDetector {

    /**
     * Clase interna que representa una coincidencia entre dos contactos.
     * Contiene los IDs de los contactos y el nivel de precisión de la coincidencia.
     */
    public static class Coincidencia {
        public int idOrigen;    // ID del contacto original
        public int idCoincide;  // ID del contacto que coincide
        public String precision; // Nivel de precisión ("Alta", "Baja", "Ninguna")

        /**
         * Constructor de la clase Coincidencia
         *
         * @param idOrigen ID del contacto original
         * @param idCoincide ID del contacto que coincide
         * @param precision Nivel de precisión de la coincidencia
         */
        public Coincidencia(int idOrigen, int idCoincide, String precision) {
            this.idOrigen = idOrigen;
            this.idCoincide = idCoincide;
            this.precision = precision;
        }

        @Override
        public String toString() {
            return idOrigen + " -> " + idCoincide + " : " + precision;
        }
    }

    /**
     * Método que encuentra todas las coincidencias entre contactos en una lista.
     * Compara cada contacto con los demás y devuelve una lista de coincidencias
     * que no sean "Ninguna".
     *
     * @param contactos Lista de contactos a analizar
     * @return Lista de coincidencias encontradas
     */
    public static List<Coincidencia> encontrarDuplicados(List<Contacto> contactos) {
        List<Coincidencia> resultados = new ArrayList<>();

        // Comparar cada contacto con todos los siguientes en la lista
        for (int i = 0; i < contactos.size(); i++) {
            Contacto c1 = contactos.get(i);
            for (int j = i + 1; j < contactos.size(); j++) {
                Contacto c2 = contactos.get(j);

                // Determinar nivel de coincidencia
                String precision = calcularPrecision(c1, c2);

                // Solo agregar coincidencias relevantes
                if (!precision.equals("Ninguna")) {
                    resultados.add(new Coincidencia(c1.getId(), c2.getId(), precision));
                }
            }
        }

        return resultados;
    }

    /**
     * Método privado que calcula el nivel de precisión de coincidencia entre dos contactos.
     *
     * Criterios:
     * - Si el email coincide → "Alta"
     * - Si solo el código postal coincide → "Baja"
     * - Si no coincide nada → "Ninguna"
     *
     * @param c1 Primer contacto
     * @param c2 Segundo contacto
     * @return Nivel de precisión de la coincidencia
     */
    private static String calcularPrecision(Contacto c1, Contacto c2) {
        if (c1.getEmail().equalsIgnoreCase(c2.getEmail())) return "Alta";
        if (c1.getCodigoPostal().equalsIgnoreCase(c2.getCodigoPostal())) return "Baja";
        return "Ninguna";
    }
}
