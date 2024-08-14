
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.List;


public class ProdutosDAO {
    
    private Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    
    public ProdutosDAO() {
        this.conn = new conectaDAO().conectar();
    }
    
    public void cadastrarProduto (ProdutosDTO produto){
        String sql = "INSERT INTO produtos(nome, valor,status) VALUES (?,?,?)";
        try{
            ps = this.conn.prepareStatement(sql);
            
            ps.setString(1, produto.getNome());
            ps.setInt(2, produto.getValor());
            ps.setString(3,produto.getStatus());
            
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
    
    //--------------------------------------------------------------------------------------
    
    public List<ProdutosDTO> listarProdutos(){
        String sql = "SELECT * FROM produtos";
        try{
            PreparedStatement pst = this.conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            List<ProdutosDTO> listaProdutos = new ArrayList<>();
            
            while(rs.next()){
                ProdutosDTO produtosDTO = new ProdutosDTO();
                
                produtosDTO.setId(rs.getInt("id"));
                produtosDTO.setNome(rs.getString("nome"));
                produtosDTO.setValor(rs.getInt("valor"));
                produtosDTO.setStatus(rs.getString("status"));
                
                listaProdutos.add(produtosDTO);
            }
        return listaProdutos;
                    
        }catch(SQLException sqle){
            System.out.println("Erro ao buscar produtos: " + sqle.getMessage());
            return new ArrayList<>();
        }
    } 
    
    //--------------------------------------------------------------------------------------
    
       public void venderProdutos(int id) {
        String sql = "UPDATE produtos SET status = 'Vendido' WHERE id = ?";
        try {
            ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Produto vendido com sucesso!");
        } catch (SQLException sqle) {
            System.out.println("Erro ao finalizar a ordem de serviço: " + sqle.getMessage());
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }
}

