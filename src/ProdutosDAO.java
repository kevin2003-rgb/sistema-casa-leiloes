

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto){
        
        
        //conn = new conectaDAO().connectDB();
        
        
    }
    
    public void venderProduto(int id) {
    String sql = "UPDATE produtos SET status='Vendido' WHERE id=?";

    try {
        conn = new conectaDAO().connectDB();
        PreparedStatement pst = conn.prepareStatement(sql);

        pst.setInt(1, id);

        pst.execute();
        pst.close();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
}
    
    
    
    public ArrayList<ProdutosDTO> listarProdutos() {

    String sql = "SELECT * FROM produtos";

    try {

        conn = new conectaDAO().connectDB();

        prep = conn.prepareStatement(sql);

        resultset = prep.executeQuery();

        while(resultset.next()) {

            ProdutosDTO produto = new ProdutosDTO();

            produto.setId(resultset.getInt("id"));
            produto.setNome(resultset.getString("nome"));
            produto.setValor(resultset.getInt("valor"));
            produto.setStatus(resultset.getString("status"));

            listagem.add(produto);

        }

    } catch (Exception e) {

        JOptionPane.showMessageDialog(null, "Erro ao listar produtos!");

    }

    return listagem;
    }
}
    
    
    
    
    