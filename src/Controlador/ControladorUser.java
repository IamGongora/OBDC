package Controlador;

import static Modelo.MySql.BuscarUsuario;
import Vista.frmUsuario;
import static Vista.frmUsuario.btnBuscar;
import static Vista.frmUsuario.btnFoto;
import static Vista.frmUsuario.lblFoto;
import static Vista.frmUsuario.txtCC;
import static Vista.frmUsuario.txtDir;
import static Vista.frmUsuario.txtName;
import static Vista.frmUsuario.txtTel;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.Renderer;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ControladorUser implements ActionListener {

    public static JFileChooser Ofd = new JFileChooser();
    public static URL url;
    public static File ruta;
    public static Renderer r;
    public static int cantidad;
    FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("JPG, PNG & GIF", "jpg", "png", "gif");
    private frmUsuario vistaUser;

    public ControladorUser(frmUsuario vistaUser) {
        this.vistaUser = vistaUser;
        btnFoto.addActionListener(this);
        btnBuscar.addActionListener(this);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       // Determinar qué botón fue presionado
        if (e.getSource()==btnFoto) {
         CargarImagen();
        }else
            if (e.getSource() == btnBuscar) {
            buscarUsuario();
        }
    }
    
        public void CargarImagen(){
        Ofd.setFileFilter(filtroImagen);
        int r = Ofd.showOpenDialog(null);
        if (r == JFileChooser.APPROVE_OPTION) {
            try {
                File f = Ofd.getSelectedFile();
                String lnom = (f.getName());
                String lpeso = ("" + f.length());
                JOptionPane.showMessageDialog(vistaUser, lnom + " , " + lpeso);
                url = Ofd.getSelectedFile().toURL();//deprecated ==> Obsoleto
                ImageIcon img = new ImageIcon(url);
                ImageIcon mitad = new ImageIcon(img.getImage().getScaledInstance(lblFoto.getWidth(),
                        lblFoto.getHeight(),
                        Image.SCALE_DEFAULT));
                //Icon fondo=new ImageIcon(imagen1.getImage().getScaledInstance(lblFoto.getWidth(),lblFoto.getHeight(),Image.SCALE_DEFAULT));
                lblFoto.setIcon(mitad);
                lblFoto.repaint();
            } catch (MalformedURLException x) {
                // TODO Auto-generated catch block
                x.printStackTrace();
            }
        }
    }
    public void buscarUsuario(){
     //configuracion bnt buscar
        //txtCC.setEditable(false);
        String cedula = txtCC.getText();
        if (cedula.equals("SELECT * FROM datos WHERE cedula")) {
            //JOptionPane.showMessageDialog(null, "INTRODUCIR CEDULA A CONSULTAR", "ERROR",JOptionPane.ERROR_MESSAGE);
            //txtCC.setText(BuscarUsuario("cedula"));
            return;
        } 
    }
    

}
