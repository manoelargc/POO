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

        // Painel para os botões
        JPanel botoesPanel = new JPanel(new FlowLayout());
        panel.add(botoesPanel, BorderLayout.NORTH);

        JButton todosButton = new JButton("Mostrar Todas");
        JButton fotosButton = new JButton("Mostrar Fotos");
        JButton filmesButton = new JButton("Mostrar Filmes");
        JButton musicasButton = new JButton("Mostrar Músicas");
        JButton cadastrarButton = new JButton("Cadastrar nova mídia");
        JButton sairButton = new JButton("Sair");
        JButton editarButton = new JButton("Editar Mídia");
        JButton excluirButton = new JButton("Excluir Mídia");
        JButton consultarPorTituloButton = new JButton("Consultar por Título");

        //botoes
        botoesPanel.add(todosButton);
        botoesPanel.add(fotosButton);
        botoesPanel.add(filmesButton);
        botoesPanel.add(musicasButton);
        botoesPanel.add(cadastrarButton);
        botoesPanel.add(editarButton);
        botoesPanel.add(excluirButton);
        botoesPanel.add(consultarPorTituloButton);
        botoesPanel.add(sairButton);


        /**
         * Botoes e acoes associadas
         */

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

        // Botão para a opção de editar mídia existente
        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Interface para obter dados do usuário
                String tituloEditar = JOptionPane.showInputDialog("Digite o título da mídia que você deseja editar:");
                String campoEditar = JOptionPane.showInputDialog("Digite o campo da mídia que você deseja editar:");
                String novoValor = JOptionPane.showInputDialog("Digite o novo valor do campo " + campoEditar + ":");

                // Lógica para editar mídia
                catalogo.editar(tituloEditar, campoEditar, novoValor);

                // Adapte conforme necessário para interagir com a GUI
            }
        });

        // Botão para a opção de excluir mídia existente
        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Interface para obter dados do usuário
                String tituloExcluir = JOptionPane.showInputDialog("Digite o título da mídia que você deseja excluir:");

                // Lógica para excluir mídia
                catalogo.delete(tituloExcluir);

                // Adapte conforme necessário para interagir com a GUI
            }
        });

// Botão para a opção de consultar mídia por título
        consultarPorTituloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Interface para obter dados do usuário
                String tituloConsulta = JOptionPane.showInputDialog("Digite o título da mídia que você deseja consultar:");

                // Lógica para consultar mídia por título
                Midia midiaConsultada = catalogo.consultaPorTitulo(tituloConsulta);

                if (midiaConsultada != null) {
                    // Exibir informações da mídia em uma nova janela
                    exibirInformacoesMidia(midiaConsultada);
                } else {
                    JOptionPane.showMessageDialog(GUI.this, "Mídia não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });



        // Cria e configura a tabela
        tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);


        // Adição do cabeçalho e tabela ao painel
        panel.add(scrollPane);



        // Configuração da janela principal
        setContentPane(panel);
        setSize(1050, 500);
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

    private void exibirInformacoesMidia(Midia midia) {
        StringBuilder informacoes = new StringBuilder();
        informacoes.append("Tipo: ").append(midia.getTipo()).append("\n");
        informacoes.append("Título: ").append(midia.getTitulo()).append("\n");
        informacoes.append("Descrição: ").append(midia.getDescricao()).append("\n");
        informacoes.append("Ano: ").append(midia.getAno()).append("\n");

        if (midia instanceof Foto) {
            Foto foto = (Foto) midia;
            informacoes.append("Fotógrafo: ").append(foto.getFotografo()).append("\n");
            informacoes.append("Pessoas: ").append(Arrays.toString(foto.getPessoas())).append("\n");
            informacoes.append("Local: ").append(foto.getLocal()).append("\n");
            informacoes.append("Data: ").append(foto.getData()).append("\n");
            informacoes.append("URL: ").append(foto.getImageUrl()).append("\n");
        } else if (midia instanceof Filme) {
            Filme filme = (Filme) midia;
            informacoes.append("Gênero: ").append(filme.getGenero()).append("\n");
            informacoes.append("Idioma: ").append(filme.getIdioma()).append("\n");
            informacoes.append("Duração: ").append(filme.getDuracao()).append("\n");
            informacoes.append("Diretor: ").append(filme.getDiretor()).append("\n");
            informacoes.append("Atores: ").append(Arrays.toString(filme.getAtores())).append("\n");
            informacoes.append("URL: ").append(filme.getImageUrl()).append("\n");
        } else if (midia instanceof Musica) {
            Musica musica = (Musica) midia;
            informacoes.append("Gênero: ").append(musica.getGenero()).append("\n");
            informacoes.append("Idioma: ").append(musica.getIdioma()).append("\n");
            informacoes.append("Duração: ").append(musica.getDuracao()).append("\n");
            informacoes.append("Compositores: ").append(Arrays.toString(musica.getCompositores())).append("\n");
            informacoes.append("Intérpretes: ").append(Arrays.toString(musica.getInterpretes())).append("\n");
            informacoes.append("URL: ").append(musica.getImageUrl()).append("\n");
        }

        JTextArea textArea = new JTextArea(informacoes.toString());
        textArea.setEditable(false);

        JOptionPane.showMessageDialog(this, new JScrollPane(textArea), "Informações da Mídia", JOptionPane.PLAIN_MESSAGE);
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
