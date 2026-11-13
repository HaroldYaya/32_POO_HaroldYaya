# Tienda de Muebles – CRUD JavaFX + MySQL (Harold Yaya)

## 1. Base de datos
Ejecuta `sql/tienda_muebles.sql` en MySQL Workbench (crea la BD, la tabla `muebles` y 7 datos de prueba).
Si tu usuario/clave no son `root` / vacío, edita `model/Conexion.java`.

## 2. Ejecutar desde el IDE
`mvn clean javafx:run`  (o ejecutar `Launcher`)

## 3. Generar el JAR ejecutable
`mvn clean package`  → `target/TiendaMuebles.jar`

## 4. Ejecutar el JAR fuera del IDE
`java -jar target/TiendaMuebles.jar`   (requiere MySQL encendido; JDK 17+)
