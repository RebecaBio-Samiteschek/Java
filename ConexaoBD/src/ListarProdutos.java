import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import java.util.List;

public class ListarProdutos extends JFrame {

    private DefaultListModel<String> listModel;

    private JList<String> producList;

    public ListarProdutos(List<Produto> produtos){
        setTitle("Lista de produtos");
        setLocationRelativeTo(null);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        listModel = new DefaultListModel<>();
        producList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(producList);
        add(scrollPane, BorderLayout.CENTER);

        for (Produto produto : produtos){
            String item = "Nome: " + produto.getNome()  + "    " +
            "Preço: " + produto.getPreco() + "    " + "Quantidade: " + produto.getQuantidade() + "\n";
            listModel.addElement(item);
        }

    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> {
            Dao dao = new Dao();
            List<Produto> produtos = dao.listarProdutos();

            ListarProdutos lis = new ListarProdutos(produtos);
            lis.setVisible(true);
        });

    }
    
}
