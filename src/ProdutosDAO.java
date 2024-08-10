
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;


public class ProdutosDAO {
    
    private Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public ProdutosDAO() {
        this.conn = new conectaDAO().conectar();
    }
    
    public void cadastrarProduto (ProdutosDTO produto){
        String sql = "INSERT INTO produtos(nome, valor) VALUES (?,?)";
        try{
            ps = this.conn.prepareStatement(sql);
            
            ps.setString(1, produto.getNome());
            ps.setInt(2, produto.getValor());
            
            ps.execute();
            
            JOptionPane.showMessageDialog(null,"Produto salvo com sucesso!");
            
        }catch(Exception e){
            System.out.println("Erro ao salvar produto:" + e.getMessage());
            JOptionPane.showMessageDialog(null,"Erro ao salvar produto!");
            
        }finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        return listagem;
    }
    
    
    
        
}

