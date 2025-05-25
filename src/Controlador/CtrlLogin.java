package Controlador;

import Vista.frmLogin;
import Modelo.ModelLogin;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        String PASSWORD = new String(vista.txtPassword.getPassword());

        if (modelo.validarUsuario(CORREO, PASSWORD)) {
            JOptionPane.showMessageDialog(null, "Acceso permitido");
            // Abrir ventana principal, cerrar login...
        } else {
            JOptionPane.showMessageDialog(null, "Usuario o clave incorrectos");
        }
    }
}