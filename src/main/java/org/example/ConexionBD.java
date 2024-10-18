package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase para gestionar la conexión a la base de datos.
 */
public class ConexionBD {
    private static Connection con = null;
    private static final String URL = "jdbc:mysql://localhost:3306/gestion_peliculas";
    private static final String user = "root";
    private static final String pass = System.getenv("DB_PASSWORD");

    /**
     * Establece y devuelve la conexión a la base de datos.
     *
     * @return La conexión establecida.
     * @throws SQLException Si ocurre un error en la conexión.
     */
    public static Connection getConnection() throws SQLException {
        if (con == null) {
            try{
                con = DriverManager.getConnection(URL, user, pass);
                System.out.println("Conexión establecida");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error al conectar con la base de datos");
            }
        }
        return con;
    }

    public static boolean testConnection() {
        try (Connection con = DriverManager.getConnection(URL, user, pass)) {
            return con != null;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public static void closeConnection() {
        if(con != null) {
            try {
                con.close();
                con = null;
                System.out.println("Conexión cerrada");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error al cerrar la conexion");
            }
        }
    }
}
