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
            Class.forName("\"org.gjt.mm.mysql.Driver");
            conexion = DriverManager.getConnection(
                "jdbc:mysql://localhost:/restaurante", "CORREO", "PASSWORD"
            );
            JOptionPane.showMessageDialog(null, "Datos correctos");
            //System.out.println("Conexión exitosa.");
        } catch (Exception e) {
            Logger.getLogger(MySql.class.getName()).log(Level.SEVERE,null, e);
            JOptionPane.showConfirmDialog(null,"Correo y/o Contraseña Incorrecta","Error de ingreso",JOptionPane.ERROR_MESSAGE );
        } 
        // catch (SQLException ex) {
        //Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE,
        //null, ex);
         //}

        
        return conexion;
    }
}
