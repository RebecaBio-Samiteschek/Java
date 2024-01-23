
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadastro extends JDialog{

    private JPanel panel;

    private JLabel labelNome;
    private JLabel labelPreco;
    private JLabel labelQuantidade;

    private JTextField textNome;
    private JTextField textPreco;
    private JTextField textQuantidade;

     private JButton buttonCancelar;
    private JButton buttonSalvar;
   
    public TelaCadastro() {
        this.inicializacao();
        this.setModal(true);
        this.setAlwaysOnTop(true);
    }
    
    public void inicializacao(){
        panel = new JPanel();

        GridLayout g1 = new GridLayout(5, 2, 10, 10);
        panel.setLayout(g1);

        labelNome = new JLabel("Nome: ");
        labelPreco = new JLabel("Preço: ");
        labelQuantidade = new JLabel("Quantidade: ");

        textNome = new JTextField();
        textPreco = new JTextField();
        textQuantidade = new JTextField();

        buttonCancelar = new  JButton("Cancelar");
        buttonSalvar = new  JButton("Salvar");

        buttonSalvar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = textNome.getText();
                String preco = textPreco.getText();
                String quantidade = textQuantidade.getText();

                Produto produto = new Produto(nome, preco, quantidade);

                new Dao().CadastrarProduto(produto);

                String msg = "Nome: " + nome + " \n" +
                    "Preço: " + preco + " \n" +
                     "Quantidade: " + quantidade;
            
        JOptionPane.showMessageDialog(TelaCadastro.this, msg);
            }
            
        });
       
        buttonCancelar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
            }
            
        });
        
        panel.add(labelNome);
        panel.add(textNome);
        panel.add(labelPreco);
        panel.add(textPreco);
        panel.add(labelQuantidade);
        panel.add(textQuantidade);
        panel.add(buttonCancelar);
        panel.add(buttonSalvar);
        
        this.setBounds(0, 0, 400, 200);
        this.add(panel);
        this.setPreferredSize(new Dimension(400, 200));
        this.setLocationRelativeTo(null);
        this.setTitle("Cadastro de Produtos");
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

}
