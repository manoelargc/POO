package GerenciadorEstoque;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


/**
 * A classe Arquivo é responsável por lidar com a leitura e escrita de dados relacionados ao estoque
 * e ao gerenciamento de notas fiscais em arquivos de texto.
 *
 * @author Manoela Resende
 * @author Eduarda Sifuentes
 */
public class Arquivo {
    /**
     * O nome do arquivo utilizado para armazenar os dados do estoque.
     */
    private static final String ESTOQUE_FILE = "estoque.txt";
    /**
     * O nome do arquivo utilizado para armazenar os dados do gerenciador de notas fiscais.
     */
    private static final String GERENCIADOR_NF_FILE = "gerenciadorNF.txt";
    private Estoque estoque;
    private GerenciadorNF gerenciadorNF;


     /**
     * Construtor da classe Arquivo.
     * Inicializa as instâncias de Estoque e GerenciadorNF carregando dados previamente salvos.
     */
    public Arquivo() {
        this.estoque = carregarEstoque();
        this.gerenciadorNF = carregarGerenciadorNF();
    }

    /**
     * Obtém a instância da classe Estoque associada ao gerenciador.
     *
     * @return A instância da classe Estoque associada ao gerenciador.
     */
    public Estoque getEstoque() {
        return estoque;
    }


    /**
     * Obtém a instância da classe GerenciadorNF associada ao gerenciador.
     *
     * @return A instância da classe GerenciadorNF associada ao gerenciador.
     */
    public GerenciadorNF getGerenciadorNF() {
        return gerenciadorNF;
    }

    /**
     * Salva os dados do estoque em um arquivo de texto.
     * @param estoque O objeto Estoque a ser salvo.
     */
    public void salvarEstoque(Estoque estoque) {
        try (PrintWriter writer = new PrintWriter(ESTOQUE_FILE)) {
            for (Produto produto : estoque.getProdutos()) {
                writer.println(produto.toCSV());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     * Carrega os dados do estoque a partir de um arquivo de texto.
     * @return O objeto Estoque com os dados carregados.
    */
    public Estoque carregarEstoque() {
        Estoque estoque = new Estoque();
        File file = new File(ESTOQUE_FILE);
        if (file.exists()) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    Produto produto = Produto.fromCSV(line);
                    estoque.addProduto(produto);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return estoque;
    }

    /**
     * Salva os dados do gerenciador de notas fiscais em um arquivo de texto.
     * @param gerenciadorNF O objeto GerenciadorNF a ser salvo.
    */
    public void salvarGerenciadorNF(GerenciadorNF gerenciadorNF) {
        try (PrintWriter writer = new PrintWriter(GERENCIADOR_NF_FILE)) {
            for (NotaFiscal nf : gerenciadorNF.getNotasFiscais()) {
                writer.println(nf.toCSV());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Carrega os dados do gerenciador de notas fiscais a partir de um arquivo de texto.
     * @return O objeto GerenciadorNF com os dados carregados.
    */
    public GerenciadorNF carregarGerenciadorNF() {
        GerenciadorNF gerenciadorNF = new GerenciadorNF();
        File file = new File(GERENCIADOR_NF_FILE);
        if (file.exists()) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    NotaFiscal nf = NotaFiscal.fromCSV(line);
                    gerenciadorNF.addNotaFiscal(nf);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return gerenciadorNF;
    }
}
