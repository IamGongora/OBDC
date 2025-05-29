package Controlador;

import Modelo.MySqlConecction;
import Vista.frmLogin;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ValLogin {

    frmLogin login = new frmLogin();
    private static String getUser;
    private static String sqlUsuario;
    private static String sqlContrasena;
    private static JOptionPane jp = new JOptionPane();

    public static boolean validarUsr() {
        MySqlConecction sql = new MySqlConecction();
        getUser = login.txtUsuario.getText();
        sqlUsuario = "SELECT usuario FROM datos WHERE usuario = " + getUser + ";";
        sqlContrasena = "SELECT contrasena FROM datos WHERE usuario = '" + getUser + "';";
        try (Connection conexion = sql.conectar();
                Statement stmt = conexion.createStatement();
                ResultSet res = stmt.executeQuery(sqlContrasena)) {

            if (res.toString().equals(login.txtPassword.getText())) {
                JOptionPane.showMessageDialog(null, "Correcto!");
            } else {
                JOptionPane.showMessageDialog(null, "Usuario o contrasena incorrecta");
            }

            sql.cerrarConexion(conexion);

        } catch (SQLException e) {
            System.out.println("Error en consulta SELECT: " + e.getMessage());

        }
    }

    public ValLogin() {

    }
}
