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

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Define the media types
                String[] tipos = {"Foto", "Filme", "Musica"};

                // Show a dropdown for media type selection
                String tipo = (String) JOptionPane.showInputDialog(
                        null,
                        "Choose media type:",
                        "Media Type",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        tipos,
                        tipos[0] // Default selection
                );

                // Check if the user canceled the selection
                if (tipo != null) {
                    String dados = JOptionPane.showInputDialog("Digite os atributos de midia no formato: Título#Descrição#Ano#Fotografo#Pessoas#Local#Data#URL");

                    // Prompt the user for media attributes
/*                    if (tipo == "Foto") {
                        String dados = JOptionPane.showInputDialog("Digite os atributos de midia no formato: Título#Descrição#Ano#Fotografo#Pessoas#Local#Data#URL");
                    } else if (tipo == "Filme") {
                        String dados = JOptionPane.showInputDialog("Digite os atributos de midia no formato: Título#Descrição#Ano#Genero#Idioma#Duracao#Diretor#Atores#URL");

                    } else if (tipo == "Musica") {
                        String dados = JOptionPane.showInputDialog("Digite os atributos de midia no formato: Título#Descrição#Ano#Genero#Idioma#Duracao#Compositores#Interpretes#URL");

                    }*/
                    // Check if the user canceled the input
                    if (dados != null) {
                        // Append tipo to the beginning of dados
                        String dadosCompleto = tipo + "#" + dados;

                        cadastrarMidia(dadosCompleto);
                    } else {
                        System.out.println("User canceled data input.");
                    }
                } else {
                    System.out.println("User canceled media type selection.");
                }
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

    /**
     * Método responsável por cadastrar uma nova mídia no catálogo.
     *
     * @param dados Os dados da nova mídia a serem cadastrados.
     */
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
