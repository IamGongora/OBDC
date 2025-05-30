package Controlador;

import Vista.frmUsuario;
import static Vista.frmUsuario.lblFoto;
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

public class ControladorUser implements ActionListener{
    public static JFileChooser Ofd = new JFileChooser();
    public static URL url;
    public static File ruta;
    public static Renderer r;  
    FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("JPG, PNG & GIF","jpg", "png", "gif");
    private frmUsuario vistaUser;
    public ControladorUser(frmUsuario vistaUser){
        this.vistaUser = vistaUser;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        //Configuracion del boton file camara
                JFileChooser btCam = new JFileChooser("./");
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
    
}
