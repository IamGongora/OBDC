package App;
import Controlador.ValLogin;
import Modelo.MySqlConecction;
import java.sql.Connection;

public class Main {
    static MySqlConecction conBd = new MySqlConecction();
    public static void main(String[] args) {
        Connection conexion = conBd.conectar();
        conBd.cerrarConexion(conexion);
        ValLogin ejemplo = new ValLogin();
        
    }
}
