# 📂 Proyecto: Detección de Contactos Duplicados

Este proyecto en **Java (21)** con **Maven (3.9)** permite identificar **contactos duplicados** a partir de un archivo Excel (`.xlsx`).  

Se utilizan:
- **Apache POI** → Lectura de archivos Excel  
- **JUnit 5** → Pruebas unitarias  
- **Maven** → Gestión del proyecto y dependencias  

---

## 🚀 Funcionalidades

✔️ Leer contactos desde un archivo Excel (`contactos.xlsx`)  
✔️ Detectar contactos duplicados según reglas:  
- Coincidencia exacta de **email** → **Alta coincidencia**  
- Coincidencia de **código postal** → **Coincidencia baja**  
✔️ Mostrar resultados en una tabla en consola  
✔️ Exportar duplicados a un archivo **CSV**  

---

## 📂 Ejemplo de archivo Excel (`contactos.xlsx`)

| Nombre   | Apellido | Email                  | Código Postal | Dirección         |
|----------|----------|------------------------|---------------|------------------|
| Juan     | Pérez    | juan.perez@mail.com    | 12345         | Calle A #123     |
| María    | López    | maria.lopez@mail.com   | 12345         | Calle B #456     |
| Juan     | Pérez    | juan.perez@mail.com    | 54321         | Calle C #789     |

---## 🖥️ Ejemplo de salida en consola

------------------------------------------------------------------
ContactoID Origen    | ContactoID Coincidencia   | Precisión 
------------------------------------------------------------------
1                    | 501                       | Baja      
2                    | 502                       | Baja      
3                    | 503                       | Baja 


## Requisitos

- Java 21
- Maven 3.9+
- Librerías incluidas en `pom.xml`:
  - **JUnit 5** para pruebas unitarias
  - **Apache POI** para manipulación de Excel

---

## Cómo ejecutar el proyecto

1. Clonar el repositorio:
```bash
git clone https://github.com/cristianlee1993/prueba-tecnica-java.git
cd contactos-duplicados

2. Compilar el proyecto con Maven
mvn clean compile
3. Ejecutar la aplicación
mvn exec:java -Dexec.mainClass="com.duplicados.App"
4. Ejecutar pruevas unitarias
mvn test

## 👤 Autor

**Cristian Alonso Lee**  

