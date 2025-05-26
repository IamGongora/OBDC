package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Modelo.MySql;
import java.sql.DriverManager;

public class ModelLogin {
    public boolean validarUsuario(String CORREO, String PASSWORD) {
        boolean acceso = false;
        try {
            Connection con = MySql.conectarLogin();
            String sql = "SELECT * FROM `usuarioadmin` WHERE CORREO='"+ CORREO +"' AND PASSWORD='" + PASSWORD +"'";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, CORREO);
            ps.setString(2, PASSWORD);
            ResultSet rs = ps.executeQuery();
            acceso = rs.next();
            con.close();
        } catch (Exception e) {
            System.err.println("Error al validar usuario: " + e);
        }
        return acceso;
    }
 
}
