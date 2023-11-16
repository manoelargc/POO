package BancoDeMidias;

import javafx.scene.Node;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class GUI extends JFrame {
    private final Catalogo catalogo;
    private final DefaultTableModel tableModel;

    public GUI() {
        catalogo = new Catalogo();
        catalogo.carregaDados("C:\\Users\\manor\\OneDrive\\Documentos\\GitHub\\POO\\TG2\\src\\main\\java\\BancoDeMidias\\CSV\\midia.csv");

        setTitle("Banco de Mídias");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton cadastrarButton = new JButton("Cadastrar nova mídia");
        //JButton exibirButton = new JButton("Exibir mídias");
        JButton sairButton = new JButton("Sair");

        // Adiciona os botões de filtro
        JButton todosButton = new JButton("Mostrar Todas");
        JButton fotosButton = new JButton("Mostrar Fotos");
        JButton filmesButton = new JButton("Mostrar Filmes");
        JButton musicasButton = new JButton("Mostrar Músicas");

        todosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirMidias("Todos");
            }
        });

        fotosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirMidias("Foto");
            }
        });

        filmesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirMidias("Filme");
            }
        });

        musicasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirMidias("Musica");
            }
        });

        panel.add(todosButton);
        panel.add(fotosButton);
        panel.add(filmesButton);
        panel.add(musicasButton);




        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarMidia();
            }
        });

 /*       exibirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Todos = null ;
                exibirMidias(Todos);
            }
        });
*/
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        panel.add(cadastrarButton);
        //panel.add(exibirButton);
        panel.add(sairButton);

        // Configuração da tabela
        tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);  // Ajusta automaticamente a largura das colunas
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane);

// Adiciona cabeçalho para a tabela
        tableModel.addColumn("Tipo");
        tableModel.addColumn("Descrição");
        tableModel.addColumn("Atributo 1");
        tableModel.addColumn("Atributo 2");
        tableModel.addColumn("Atributo 3");

// Restante do código
        setContentPane(panel);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    private void cadastrarMidia() {
        JFrame cadastroFrame = new JFrame("Cadastro de Mídia");
        cadastroFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        cadastroFrame.setSize(400, 300);
        cadastroFrame.setLocationRelativeTo(this);

        JPanel cadastroPanel = new JPanel();
        cadastroPanel.setLayout(new BoxLayout(cadastroPanel, BoxLayout.Y_AXIS));
        cadastroPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel tipoLabel = new JLabel("Tipo de Mídia:");
        String[] tipos = {"Foto", "Filme", "Musica"};
        JComboBox<String> tipoComboBox = new JComboBox<>(tipos);
        tipoComboBox.setSelectedItem("Foto");

        JTextArea camposTextArea = new JTextArea();
        camposTextArea.setLineWrap(true);
        camposTextArea.setWrapStyleWord(true);
        camposTextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        camposTextArea.setToolTipText("Digite os campos da mídia separados por #");

        JButton cadastrarMidiaButton = new JButton("Cadastrar Mídia");

        cadastrarMidiaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarMidia(camposTextArea.getText());
                camposTextArea.setText("");
                cadastroFrame.dispose();
            }
        });

        cadastroPanel.add(tipoLabel);
        cadastroPanel.add(tipoComboBox);
        cadastroPanel.add(camposTextArea);
        cadastroPanel.add(cadastrarMidiaButton);

        cadastroFrame.setContentPane(cadastroPanel);
        cadastroFrame.setVisible(true);
    }

    private void cadastrarMidia(String dados) {
        String[] campos = dados.split("#");

        String tipo = campos[0];
        if (tipo.equalsIgnoreCase("Foto")) {
            Foto foto = LeitorCSV.criarFoto(Arrays.copyOfRange(campos, 1, campos.length));
            catalogo.insere(foto);
        } else if (tipo.equalsIgnoreCase("Filme")) {
            Filme filme = LeitorCSV.criarFilme(Arrays.copyOfRange(campos, 1, campos.length));
            catalogo.insere(filme);
        } else if (tipo.equalsIgnoreCase("Musica")) {
            Musica musica = LeitorCSV.criarMusica(Arrays.copyOfRange(campos, 1, campos.length));
            catalogo.insere(musica);
        }
    }

    private void exibirMidias(String tipoFiltro) {
        // Limpa a tabela antes de exibir as novas mídias
        tableModel.setRowCount(0);

        // Adiciona as informações das mídias à tabela, considerando o filtro
        for (int i = 0; i < catalogo.getMidias().getTamanho(); i++) {
            Nodo node = catalogo.getMidias().get(i);
            if (node != null) {
                Midia midia = (Midia) node.getValor();

                // Adiciona à tabela apenas se o tipo corresponder ao filtro
                if (tipoFiltro.equals("Todos") || midia.getTipo().equalsIgnoreCase(tipoFiltro)) {
                    adicionarMidiaNaTabela(midia);
                }
            }
        }
    }

    private void adicionarMidiaNaTabela(Midia midia) {
        Object[] rowData;

        if (midia instanceof Foto) {
            rowData = new Object[]{midia.getTipo(), midia.getDescricao(), ((Foto) midia).getFotografo(), ((Foto) midia).getLocal(), ((Foto) midia).getImageUrl()};
        } else if (midia instanceof Filme) {
            rowData = new Object[]{midia.getTipo(), midia.getDescricao(), ((Filme) midia).getDiretor(), Arrays.toString(((Filme) midia).getAtores()), ((Filme) midia).getImageUrl()};
        } else if (midia instanceof Musica) {
            rowData = new Object[]{midia.getTipo(), midia.getDescricao(), Arrays.toString(((Musica) midia).getCompositores()), Arrays.toString(((Musica) midia).getInterpretes()), ((Musica) midia).getImageUrl()};
        } else {
            // Se houver um novo tipo de mídia, adicione aqui
            return;
        }

        tableModel.addRow(rowData);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GUI();
            }
        });
    }
}
