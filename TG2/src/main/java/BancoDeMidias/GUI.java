package BancoDeMidias;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class GUI extends JFrame {
    private final Catalogo catalogo;

    public GUI() {
        catalogo = new Catalogo();
        catalogo.carregaDados("C:\\Users\\manor\\OneDrive\\Documentos\\GitHub\\POO\\TG2\\src\\main\\java\\BancoDeMidias\\CSV\\midia.csv");

        setTitle("Banco de Mídias");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton cadastrarButton = new JButton("Cadastrar nova mídia");
        JButton exibirButton = new JButton("Exibir mídias");
        JButton sairButton = new JButton("Sair");

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarMidia();
            }
        });

        exibirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirMidias();
            }
        });

        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        panel.add(cadastrarButton);
        panel.add(exibirButton);
        panel.add(sairButton);

        setContentPane(panel);
        setSize(300, 200);
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

    private void exibirMidias() {
        JFrame exibirFrame = new JFrame("Exibir Mídias");
        exibirFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        exibirFrame.setSize(400, 300);
        exibirFrame.setLocationRelativeTo(this);

        JTextArea exibirTextArea = new JTextArea();
        exibirTextArea.setEditable(false);


        // Adiciona as informações das mídias à JTextArea
        for (int i = 0; i < catalogo.getMidias().getTamanho(); i++) {
            Midia midia = (Midia) catalogo.getMidias().get(i).getValor();
            exibirTextArea.append(midia.toString() + "\n");
        }

        JScrollPane scrollPane = new JScrollPane(exibirTextArea);
        exibirFrame.add(scrollPane);

        exibirFrame.setVisible(true);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GUI();
            }
        });
    }
}
