package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Modelo.MySql;

public class ModelLogin {
    
    public boolean validarUsuario(String CORREO, String PASSWORD) {
        boolean acceso = false;
        try {
            Connection con = MySql.conectarLogin();
            String sql = "SELECT * FROM usuarioadmin WHERE CORREO=? AND PASSWORD=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, CORREO);
            ps.setString(2, PASSWORD);
            ResultSet rs = ps.executeQuery();
            acceso = rs.next();
        } catch (Exception e) {
            System.err.println("Error al validar usuario: " + e);
        }
        return acceso;
    }
   
       
    
}
