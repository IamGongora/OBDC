package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class MySql {
//Conexion a base de datos para el login
    private static Connection conexion;

    public static Connection conectarLogin() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/restaurante", "root", "tu_contraseña"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
