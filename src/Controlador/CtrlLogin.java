package Controlador;

import Vista.frmLogin;
import Modelo.ModelLogin;
import Ppal.ClasePpal;
import static Vista.frmLogin.txtPassword;
import static Vista.frmLogin.txtUsuario;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;


public class CtrlLogin implements ActionListener {
     frmLogin vista;
     ModelLogin modelo;
     
     public CtrlLogin(frmLogin Vistalogin, ModelLogin ModelLogin) {
        this.vista = Vistalogin;
        this.modelo = ModelLogin;

        frmLogin.btnLogeo.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String CORREO = vista.txtUsuario.getText();
        String PASSWORD =  new String(vista.txtPassword.getPassword());
    }
}