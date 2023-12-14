package GerenciadorEstoque;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Arquivo {
    private static final String ESTOQUE_FILE = "estoque.txt";
    private static final String GERENCIADOR_NF_FILE = "gerenciadorNF.txt";
    private Estoque estoque;
    private GerenciadorNF gerenciadorNF;

    public Arquivo() {
        this.estoque = carregarEstoque();
        this.gerenciadorNF = carregarGerenciadorNF();
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public GerenciadorNF getGerenciadorNF() {
        return gerenciadorNF;
    }

    public void salvarEstoque(Estoque estoque) {
        try (PrintWriter writer = new PrintWriter(ESTOQUE_FILE)) {
            for (Produto produto : estoque.getProdutos()) {
                writer.println(produto.toCSV());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

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

    public void salvarGerenciadorNF(GerenciadorNF gerenciadorNF) {
        try (PrintWriter writer = new PrintWriter(GERENCIADOR_NF_FILE)) {
            for (NotaFiscal nf : gerenciadorNF.getNotasFiscais()) {
                writer.println(nf.toCSV());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public GerenciadorNF carregarGerenciadorNF() {
        GerenciadorNF gerenciadorNF = new GerenciadorNF();
        File file = new File(GERENCIADOR_NF_FILE);
        if (file.exists()) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    NotaFiscal nf = NotaFiscal.fromCSV(line,estoque);
                    gerenciadorNF.addNotaFiscal(nf);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return gerenciadorNF;
    }
}
