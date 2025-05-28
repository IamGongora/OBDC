<<<<<<< HEAD
package Ppal;

import Controlador.CtrlLogin;
import Modelo.ModelLogin;
import Vista.frmLogin;
import java.sql.Connection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC
 */
public class ClasePpal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       
        
        frmLogin login = new frmLogin();
        ModelLogin Mlogin = new ModelLogin();
        CtrlLogin controlador = new CtrlLogin(login, Mlogin);

        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }
    
}
=======
package Ppal;

import Controlador.CtrlLogin;
import Modelo.ModelLogin;
import Vista.frmLogin;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC
 */
public class ClasePpal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        frmLogin login = new frmLogin();
        ModelLogin Mlogin = new ModelLogin();
        CtrlLogin controlador = new CtrlLogin(login, Mlogin);

        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }
    
}
>>>>>>> 629b0a4a0a07ad412eb64cf4714f8018caa7ca5d
