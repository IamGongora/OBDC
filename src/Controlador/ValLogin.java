package Controlador;

import Modelo.MySqlConecction;
import Vista.frmLogin;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ValLogin {

    private static frmLogin login = new frmLogin();
    private static String sqlQuery;
    private static JOptionPane jp = new JOptionPane();
    private static ResultSet res = null;
    private static PreparedStatement stmt = null;
    private static Connection conexion = null;
    private static FileInputStream fis = null;

    public static boolean validarUsr(String usuario, String clave) {
        MySqlConecction sql = new MySqlConecction();
        
    
        try {
            conexion = sql.conectar();
            sqlQuery = "SELECT usuario FROM datos WHERE usuario = ? AND contrasena = ?";
            stmt = conexion.prepareStatement(sqlQuery);
            stmt.setString(1, usuario);
            stmt.setString(2, clave);
            res = stmt.executeQuery();
            return res.next();

        } catch (SQLException e) {
            System.out.println("Error en validar usuario: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            try {
                if(res != null) res.close();
                if(stmt != null) stmt.close();
                if(conexion != null) conexion.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public static boolean insertDatos(String cedula, String nombre, String tel, String dir, String usuario, String clave, String rutaImg) {
        MySqlConecction sql = new MySqlConecction();
        try {
            conexion = sql.conectar();
            sqlQuery = "INSERT INTO datos VALUES(?, ?, ?, ?, ?, ?, ?)";
            stmt = conexion.prepareStatement(sqlQuery);
            stmt.setString(1, cedula);
            stmt.setString(2, nombre);
            stmt.setString(3, tel);
            stmt.setString(4, dir);
            stmt.setString(5, usuario);
            stmt.setString(6, clave);
            File archivo = new File(rutaImg);
            fis = new FileInputStream(archivo);
            stmt.setBinaryStream(7, fis, (int) archivo.length());
            int filas = stmt.executeUpdate();
            return filas > 0;
        } catch(SQLException e) {
            System.out.println("Error en insertar los datos: " + e.getMessage());
            e.printStackTrace();
            return false;
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "No se encontro el archivo");
            ex.printStackTrace();
            return false;
        } finally {
            try {
               if(stmt != null) stmt.close();
               if(conexion != null) conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public ValLogin() {
        
    }
}
