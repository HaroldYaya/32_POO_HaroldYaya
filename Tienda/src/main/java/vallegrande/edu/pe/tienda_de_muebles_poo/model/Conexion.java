package vallegrande.edu.pe.tienda_de_muebles_poo.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL =
            "jdbc:mysql://localhost:3307/tienda_muebles"
                    + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=America/Lima";

    private static final String USUARIO = "root";
    private static final String CLAVE = "123456";

    public static Connection obtener() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CLAVE);
    }
}