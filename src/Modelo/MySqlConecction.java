package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySqlConecction {

    private static final String ruta = "jdbc:mysql://localhost:3306/bdpfinal";
    private static final String usuario = "root";
    private static final String contrasena = "";

    public static Connection conectar() {
        Connection conexion = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(ruta, usuario, contrasena);
            System.out.println("Conexion exitosa");
        } catch (ClassNotFoundException e) {
            System.err.println("No se encontro el driver.");
        } catch (SQLException e) {
            System.err.println("Error en la conexion a la BD.");
            e.printStackTrace();
        }

        return conexion;
    }

    public static void cerrarConexion(Connection conexion) {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("Conexion cerrada");
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexion");
            e.printStackTrace();
        }
    }
}
