package BancoDeMidias;

/**
 * APP Interface grafica do usuario
 *
 * @author Manoela Resende
 * @author Eduarda Sifuentes
 */

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class GUI extends JFrame {
    private final Catalogo catalogo;
    private final DefaultTableModel tableModel;



    /**
     * Construtor da classe GUI.
     */
    public GUI() {
        catalogo = new Catalogo();
        catalogo.carregaDados("C:\\Users\\manor\\OneDrive\\Documentos\\GitHub\\POO\\TG2\\src\\main\\java\\BancoDeMidias\\CSV\\midia.csv");

        setTitle("Banco de Mídias");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            // Set Nimbus Look and Feel
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


        /**
         * Botoes e acoes associadas
         */
        JButton cadastrarButton = new JButton("Cadastrar nova mídia");
        cadastrarButton.setBackground(Color.white);
        cadastrarButton.setForeground(Color.black);

        JButton sairButton = new JButton("Sair");
        sairButton.setBackground(Color.white);
        sairButton.setForeground(Color.black);

        JButton todosButton = new JButton("Mostrar Todas");
        todosButton.setBackground(Color.white);
        todosButton.setForeground(Color.black);

        JButton fotosButton = new JButton("Mostrar Fotos");
        fotosButton.setBackground(Color.white);
        fotosButton.setForeground(Color.BLACK);

        JButton filmesButton = new JButton("Mostrar Filmes");
        filmesButton.setBackground(Color.white);
        filmesButton.setForeground(Color.BLACK);

        JButton musicasButton = new JButton("Mostrar Músicas");
        musicasButton.setBackground(Color.white);
        musicasButton.setForeground(Color.BLACK);

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

        // Adição dos botões ao painel
        panel.add(todosButton);
        panel.add(fotosButton);
        panel.add(filmesButton);
        panel.add(musicasButton);

        // Create a JComboBox for media type selection
        String[] tipos = {"Foto", "Filme", "Musica"};
        JComboBox<String> tipoComboBox = new JComboBox<>(tipos);
        //panel.add(tipoComboBox);

        cadastrarButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtém o tipo selecionado do JComboBox
                String tipo = (String) tipoComboBox.getSelectedItem();

                // Chama o método cadastrarMidia, passando o tipo selecionado
                cadastrarMidia(tipo);
            }

        });
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        panel.add(cadastrarButton);
        panel.add(sairButton);

        tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        JScrollPane scrollPane = new JScrollPane(table);
        // Adição do cabeçalho e tabela ao painel
        panel.add(scrollPane);


        // Configuração da janela principal
        setContentPane(panel);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Method to show input dialog based on media type
    private String showInputDialogForMediaType(String tipo) {
        String dados = "";

        switch (tipo) {
            case "Foto":
                dados = JOptionPane.showInputDialog("Digite os atributos de mídia no formato: Título#Descrição#Ano#Fotógrafo#Pessoas#Local#Data#URL");
                break;
            case "Filme":
                dados = JOptionPane.showInputDialog("Digite os atributos de mídia no formato: Título#Descrição#Ano#Gênero#Idioma#Duração#Diretor#Atores#URL");
                break;
            case "Musica":
                dados = JOptionPane.showInputDialog("Digite os atributos de mídia no formato: Título#Descrição#Ano#Gênero#Idioma#Duração#Compositores#Intérpretes#URL");
                break;
            default:
                System.err.println("Tipo de mídia não reconhecido: " + tipo);
        }

        return dados;
    }
    // Método para cadastrar a mídia com base no tipo e dados fornecidos
    private void cadastrarMidia(String tipo) {
        // Obter os dados do usuário com base no tipo de mídia

        String[] tipos = {"Foto", "Filme", "Musica"};
        JComboBox<String> tipoComboBox = new JComboBox<>(tipos);
        int result = JOptionPane.showConfirmDialog(this, tipoComboBox, "Selecione o Tipo de Mídia", JOptionPane.OK_CANCEL_OPTION);
        // Verifique se o usuário pressionou "OK"
        if (result == JOptionPane.OK_OPTION) {
            // Obtenha o tipo de mídia selecionado
            String tipoSelecionado = (String) tipoComboBox.getSelectedItem();

            // Exiba um JOptionPane para obter os atributos da mídia com base no tipo selecionado
            String dados = showInputDialogForMediaType(tipoSelecionado);

            // Verifique se o usuário não cancelou a entrada
            if (dados != null) {
                // Processar a entrada e inserir a mídia no catálogo
                String linha = tipoSelecionado + "#" + dados;
                String[] campos = linha.split("#");

                if (tipoSelecionado.equalsIgnoreCase("Foto")) {
                    Foto foto = LeitorCSV.criarFoto(campos);
                    catalogo.insere(foto);
                } else if (tipoSelecionado.equalsIgnoreCase("Filme")) {
                    Filme filme = LeitorCSV.criarFilme(campos);
                    catalogo.insere(filme);
                } else if (tipoSelecionado.equalsIgnoreCase("Musica")) {
                    Musica musica = LeitorCSV.criarMusica(campos);
                    catalogo.insere(musica);
                }
            }
        }
    }
    /*  *//**
     * Método responsável por cadastrar uma nova mídia no catálogo.
     *
     * @param dados Os dados da nova mídia a serem cadastrados.
     *//*
    private void cadastrarMidia(String dados) {
        try {
            if (dados != null) {
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
                } else {
                    System.err.println("Tipo de mídia não reconhecido: " + tipo);
                }
            } else {
                System.err.println("Dados nulos. Verifique os dados e tente novamente.");
            }
        } catch (Exception e) {
            e.printStackTrace(); // Exibe detalhes da exceção no console
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar mídia. Verifique os dados e tente novamente.");
        }
    }
*/
    private boolean cabecalhoAdicionado = false; // Adicione esta variável de instância

    /**
     * Método responsável por adicionar o cabeçalho na tabela.
     *
     * @param tipo O tipo de mídia para o qual o cabeçalho está sendo adicionado.
     */
    private void adicionarCabecalhoNaTabela(String tipo) {
        if (!cabecalhoAdicionado) {
            // Limpa as colunas existentes
            tableModel.setColumnCount(0);

            // Adiciona as colunas com base no tipo de mídia
            tableModel.addColumn("Tipo");
            tableModel.addColumn("Título");
            tableModel.addColumn("Descrição");
            tableModel.addColumn("Ano");


            if (tipo.equalsIgnoreCase("Foto")) {
                tableModel.addColumn("Fotógrafo");
                tableModel.addColumn("Pessoas");
                tableModel.addColumn("Local");
                tableModel.addColumn("Data");
                tableModel.addColumn("URL");
            } else if (tipo.equalsIgnoreCase("Filme")) {
                tableModel.addColumn("Gênero");
                tableModel.addColumn("Idioma");
                tableModel.addColumn("Duração");
                tableModel.addColumn("Diretor");
                tableModel.addColumn("Atores");
                tableModel.addColumn("URL");
            } else if (tipo.equalsIgnoreCase("Musica")) {
                tableModel.addColumn("Gênero");
                tableModel.addColumn("Idioma");
                tableModel.addColumn("Duração");
                tableModel.addColumn("Compositores");
                tableModel.addColumn("Intérpretes");
                tableModel.addColumn("URL");
            }

            cabecalhoAdicionado = true;
        }
    }


    /**
     * Método responsável por exibir as mídias na tabela com base no tipo de filtro.
     *
     * @param tipoFiltro O tipo de mídia a ser filtrado.
     */
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
                    adicionarCabecalhoNaTabela(midia.getTipo()); // Adiciona o cabeçalho apenas uma vez
                    adicionarMidiaNaTabela(midia);
                }
            }
        }

        // Reinicie a variável para que o cabeçalho seja adicionado na próxima vez que a tabela for atualizada
        cabecalhoAdicionado = false;
    }


    /**
     * Método responsável por adicionar uma nova mídia à tabela.
     *
     * @param midia A mídia a ser adicionada.
     */
    private void adicionarMidiaNaTabela(Midia midia) {
        Object[] rowData;

        if (midia instanceof Foto) {
            rowData = new Object[]{midia.getTipo(), midia.getTitulo(),midia.getDescricao(), midia.getAno(),((Foto) midia).getFotografo(), Arrays.toString(((Foto) midia).getPessoas()),((Foto) midia).getLocal(), ((Foto) midia).getData(),((Foto) midia).getImageUrl()};
        } else if (midia instanceof Filme) {
            rowData = new Object[]{midia.getTipo(),  midia.getTitulo(), midia.getDescricao(), midia.getAno(), ((Filme) midia).getGenero(), ((Filme) midia).getIdioma(),((Filme) midia).getDuracao(),((Filme) midia).getDiretor(), Arrays.toString(((Filme) midia).getAtores()), ((Filme) midia).getImageUrl()};
        } else if (midia instanceof Musica) {
            rowData = new Object[]{midia.getTipo(),  midia.getTitulo(), midia.getDescricao(), midia.getAno(), ((Musica) midia).getGenero(), ((Musica) midia).getIdioma(),((Musica) midia).getDuracao(),Arrays.toString(((Musica) midia).getCompositores()), Arrays.toString(((Musica) midia).getInterpretes()), ((Musica) midia).getImageUrl()};
        } else {
            // Se houver um novo tipo de mídia, adicione aqui
            return;
        }

        tableModel.addRow(rowData);
    }


    /**
     * Método principal que inicia a aplicação GUI.
     *
     * @param args Argumentos da linha de comando (não utilizado neste caso).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GUI();
            }
        });
    }
}
