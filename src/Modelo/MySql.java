package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.SQLException;

public class MySql {
//Conexion a base de datos para el login
    private static  Connection Conexion;
    
    
    public static Connection MySQLConnection(String CORREO, String PASSWORD, String restaurante) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Conexion =DriverManager.getConnection("jdbc:mysql://localhost:3306/" + restaurante, "root", "");
            System.out.println("Se ha iniciado la conexión con el servidor de forma exitosa");
            } catch (ClassNotFoundException ex) {

                Logger.getLogger(MySql.class.getName()).log(Level.SEVERE,null, ex);
            } catch (SQLException ex) {

            Logger.getLogger(MySql.class.getName()).log(Level.SEVERE,null, ex);
        }
        return Conexion;
    }
}
