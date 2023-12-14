package GerenciadorEstoque;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Classe abstrata Produto que serve como base para outras classes de produto (por unidade e por quilo), classe mãe
 *
 * @author Manoela Resende
 * @author Eduarda Sifuentes
 */
public class Produto {

    // atributos
    private static int contador = 0;
    private int codigo;
    private String nome;
    private String descricao;
    private double preco;
    private Date validade;
    private double quantidade;


    /**
     * Construtor padrão/vazio da classe Produto
     */
    public Produto() {
    }

    /**
     * Construtor para a classe Produto.
     *
     * @param nome       O nome do produto.
     * @param descricao  A descrição do produto.
     * @param preco      O preço do produto.
     * @throws IllegalArgumentException Se o nome ou a descrição estiverem vazios, ou se o preço for menor ou igual a zero.
     */
    public Produto(String nome, String descricao, double preco, double quantidade) throws IllegalArgumentException {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio.");
        }
        if (descricao == null || descricao.isEmpty()) {
            throw new IllegalArgumentException("Descrição não pode ser vazia.");
        }
        if (preco <= 0) {
            throw new IllegalArgumentException("Preço deve ser maior que zero.");
        }
        if (quantidade < 0) {
            throw new IllegalArgumentException("Quantidade não pode ser negativa.");
        }
        this.quantidade = quantidade;
        this.codigo = ++contador;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }
    /**
     * Retorna o código do produto.
     *
     * @return O código do produto.
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Define o código do produto.
     *
     * @param codigo O novo código do produto.
     * @throws IllegalArgumentException Se o código for menor ou igual a zero.
     */
    public void setCodigo(int codigo) throws IllegalArgumentException {
        if (codigo <= 0) {
            throw new IllegalArgumentException("Código deve ser maior que zero.");
        }
        this.codigo = codigo;
    }

    /**
     * Retorna o nome do produto.
     *
     * @return O nome do produto.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do produto.
     *
     * @param nome O novo nome do produto.
     * @throws IllegalArgumentException Se o nome estiver vazio.
     */
    public void setNome(String nome) throws IllegalArgumentException {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio.");
        }
        this.nome = nome;
    }

    /**
     * Retorna a descrição do produto.
     *
     * @return A descrição do produto.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Define a descrição do produto.
     *
     * @param descricao A nova descrição do produto.
     * @throws IllegalArgumentException Se a descrição estiver vazia.
     */
    public void setDescricao(String descricao) throws IllegalArgumentException {
        if (descricao == null || descricao.isEmpty()) {
            throw new IllegalArgumentException("Descrição não pode ser vazia.");
        }
        this.descricao = descricao;
    }

    /**
     * Retorna o preço do produto.
     *
     * @return O preço do produto.
     */
    public double getPreco() {
        return preco;
    }

    /**
     * Define o preço do produto.
     *
     * @param preco O novo preço do produto.
     * @throws IllegalArgumentException Se o preço for menor ou igual a zero.
     */
    public void setPreco(double preco) throws IllegalArgumentException {
        if (preco <= 0) {
            throw new IllegalArgumentException("Preço deve ser maior que zero.");
        }
        this.preco = preco;
    }

    /**
     * Retorna a data de validade do produto.
     *
     * @return A data de validade do produto.
     */
    public String getValidade() {
        if (validade == null) {
            // Cria uma data atual
            Calendar cal = Calendar.getInstance();
            // Adiciona um ano à data atual
            cal.add(Calendar.YEAR, 1);
            // Define a data de validade como um ano a partir da data atual
            validade = cal.getTime();
        }
        // Formata a data de validade para uma string
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(validade);
    }

    /**
     * Define a data de validade do produto.
     *
     * @param validade A nova data de validade do produto.
     */
    public void setValidade(String validade) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date data = formato.parse(validade);
            this.validade = data;
        } catch (ParseException e) {
            System.out.println("Erro ao analisar a data. Por favor, insira a data no formato dd/MM/yyyy.");
        }
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) throws IllegalArgumentException {
        if (quantidade < 0) {
            throw new IllegalArgumentException("Quantidade não pode ser negativa.");
        }
        this.quantidade = quantidade;
    }

    /**
     * Retorna uma representação em string do produto.
     *
     * @return Uma representação em string do produto.
     */
    @Override
    public String toString() {
        return "\n" + "Produto " + codigo + "\n" +
                "Nome= " + nome +
                ", descricao= " + descricao +
                ", preco= " + preco +
                ", validade=" + getValidade();
    }
}
