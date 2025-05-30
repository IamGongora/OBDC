package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MySql {
//Conexion a base de datos para el login

    private static Connection conexion;

    public static Connection conectarLogin() {
        try {
            Class.forName("\"org.gjt.mm.mysql.Driver");
            conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost:/restaurante", "CORREO", "PASSWORD"
            );
            JOptionPane.showMessageDialog(null, "Datos correctos");
            //System.out.println("Conexión exitosa.");
        } catch (Exception e) {
            Logger.getLogger(MySql.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showConfirmDialog(null, "Correo y/o Contraseña Incorrecta", "Error de ingreso", JOptionPane.ERROR_MESSAGE);
        }
        // catch (SQLException ex) {
        //Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE,
        //null, ex);
        //}       
        return conexion;
    }

    public static void BuscarUsuario(String datos) {
        try {
            String Query = "SELECT * FROM " + datos;
            Statement st = conexion.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
            while (resultSet.next()) {
                System.out.println("ID: "
                        + resultSet.getString("ID") + " "
                        + "Nombre: "
                        + resultSet.getString("Nombre") + " "
                        + resultSet.getString("Apellido") + " "
                        + "Edad: " + resultSet.getString("Edad") + ""
                        + "Sexo: " + resultSet.getString("Sexo")
                );
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
        }
    }

}

