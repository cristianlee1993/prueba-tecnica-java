package com.duplicados;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase responsable de leer contactos desde un archivo Excel (.xlsx).
 * Utiliza Apache POI para procesar hojas de cálculo.
 */
public class ExcelReader {

    /**
     * Lee los contactos desde un archivo Excel ubicado en resources.
     * Cada fila del archivo representa un contacto.
     *
     * @param archivo Nombre del archivo Excel (ej. "contactos.xlsx")
     * @return Lista de objetos Contacto con la información leída
     * @throws IOException Si ocurre un error al abrir o leer el archivo
     */
    public static List<Contacto> leerContactos(String archivo) throws IOException {
        List<Contacto> contactos = new ArrayList<>();

        // Obtener el archivo desde la carpeta resources del proyecto
        InputStream fis = ExcelReader.class.getClassLoader().getResourceAsStream(archivo);

        // Crear un workbook de Apache POI para leer el archivo Excel
        Workbook workbook = new XSSFWorkbook(fis);

        // Obtener la primera hoja del Excel
        Sheet sheet = workbook.getSheetAt(0);

        // Iterar sobre cada fila de la hoja
        for (Row row : sheet) {
            if (row.getRowNum() == 0) continue; // Saltar la fila del encabezado

            // Leer los valores de cada celda
            int id = (int) row.getCell(0).getNumericCellValue();
            String nombre = row.getCell(1).getStringCellValue();
            String apellido = row.getCell(2).getStringCellValue();
            String email = row.getCell(3).getStringCellValue();
            String codigoPostal = row.getCell(4).toString();
            String direccion = row.getCell(5) != null ? row.getCell(5).getStringCellValue() : "";

            // Crear un objeto Contacto y agregarlo a la lista
            contactos.add(new Contacto(id, nombre, apellido, email, codigoPostal, direccion));
        }

        // Cerrar recursos para liberar memoria
        workbook.close();
        fis.close();

        return contactos;
    }
}
