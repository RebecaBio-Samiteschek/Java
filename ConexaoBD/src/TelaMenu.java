import java.awt.BorderLayout;
import java.util.List;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class TelaMenu extends JFrame{

    
    private JPanel panel;
    private JPanel panelBotoes;

    private JLabel labelTitulo;
    
    private JButton btNovo;
    private JButton btMostrarProduto;
    private JButton btSair;

    private JMenuBar bMenu;
    private JMenu menuProgama;

    private JMenuItem menuCadastrar;
    private JMenuItem menuSair;

    public TelaMenu(){

        Connection conex = ConexaoDB.getConexao();

        this.inicializacao();
        this.setExtendedState(NORMAL);
    }

    public void inicializacao(){

        panel = new JPanel();
        panelBotoes = new JPanel();
        
        panel.setLayout(new BorderLayout(5, 5));

        this.setBounds(0, 0, 600, 300);
        this.setPreferredSize(new Dimension(600,300));

        bMenu = new JMenuBar();
        
        menuProgama = new JMenu("Progama");
        menuCadastrar = new JMenuItem("Cadastrar");
        menuSair = new JMenuItem("Sair");

        menuCadastrar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCadastro c = new TelaCadastro();
            }
            
        });

        menuSair.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
                System.exit(0);
            }

        });

        btNovo = new JButton("Novo");
        btMostrarProduto = new JButton("Listar produtos");
        btSair = new JButton("Sair");

        btNovo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCadastro c = new TelaCadastro();
            }
            
        });

        btMostrarProduto.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    Dao dao = new Dao();
                    List<Produto> produtos = dao.listarProdutos();

                    ListarProdutos lis = new ListarProdutos(produtos);
                    lis.setVisible(true);
                });
            }
            
        });

        btSair.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
                System.exit(0);
                }

        });

        panelBotoes.setLayout(new GridLayout(6,1,10,10));
        panelBotoes.add(btNovo);
        panelBotoes.add(btMostrarProduto);
        panelBotoes.add(btSair);

        labelTitulo = new JLabel("Cadastro de Produtos");
        panel.add(labelTitulo, BorderLayout.PAGE_START);
        panel.add(panelBotoes, BorderLayout.LINE_END);

        menuProgama.add(menuCadastrar);
        menuProgama.addSeparator();
        menuProgama.add(menuSair);

        bMenu.add(menuProgama);

        this.setJMenuBar(bMenu);

        this.add(panel);
        this.setTitle("Cadastro de Produtos");
        this.setLocationRelativeTo(null);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }
    
}
