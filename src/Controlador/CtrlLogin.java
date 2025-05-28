package Controlador;

import Vista.frmLogin;
import Modelo.ModelLogin;
import Ppal.ClasePpal;
import static Vista.frmLogin.txtPassword;
import static Vista.frmLogin.txtUsuario;
import Vista.frmUsuario;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;


public class CtrlLogin implements ActionListener {
     frmLogin formLogin;
     ModelLogin ModelLogin;
     
     public CtrlLogin(frmLogin Vistalogin, ModelLogin ModelLogin) {
        this.formLogin = Vistalogin;
        this.ModelLogin = ModelLogin;

        frmLogin.btnLogeo.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        String CORREO = txtUsuario.getText();
        String PASSWORD = txtPassword.getText();
        if (!CORREO.equals("")||!PASSWORD.equals("")) 
        {
            try {
                
            } catch (Exception e) {
            }
            
        }else{
            JOptionPane.showMessageDialog(null,"DATOS INCORRECTOS");
        }
        
    }
}