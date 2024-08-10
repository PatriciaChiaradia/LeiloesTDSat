
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class conectaDAO {
     /**Variável de conexão*/
    Connection conn = null;
    
    /**Método para estabelecer a conexão com o banco de dado
     * @return s*/
    public Connection conectar(){
        
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/uc11?useSSL=false","root","Kiara1985");
            return conn;    
        } catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ConectaDAO" + erro.getMessage());
            return null;
        }
    } 
}
