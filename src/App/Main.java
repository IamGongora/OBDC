package App;
import Modelo.MySqlConecction;

public class Main {
    static MySqlConecction conBd = new MySqlConecction();
    public static void main(String[] args) {
        conBd.conectar();
    }
}
