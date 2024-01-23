import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Dao {
    
    public void CadastrarProduto(Produto produto){

        String sql = "INSERT INTO PRODUTO (NOME, PRECO, QUANTIDADE) VALUES (?, ?, ?)";

        try {
            PreparedStatement ps = ConexaoDB.getConexao().prepareStatement(sql);
            ps.setString(1, produto.getNome());
            ps.setString(2, produto.getPreco());
            ps.setString(3, produto.getQuantidade());

            ps.execute();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Produto> listarProdutos(){

        List<Produto> produtos = new ArrayList<>();
        String sqlString = "SELECT * FROM produto";
        PreparedStatement ps = null;

        try {
            ps = ConexaoDB.getConexao().prepareStatement(sqlString);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String nome = rs.getString("nome");
                String preco = rs.getString("preco");
                String quantidade = rs.getString("quantidade");
                Produto produto = new Produto(nome, preco, quantidade);
                produtos.add(produto);              
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
             e.printStackTrace();
        }
        return produtos;
    }

}
