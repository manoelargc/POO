package GerenciadorEstoque;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Produto {

    // atributos
    private static int contador = 0;
    private int codigo;
    private String nome;
    private String descricao;
    private double preco;
    private Date validade;

    // construtor
    public Produto(String nome, String descricao, double preco) {
        this.codigo = ++contador;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    // get e set
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

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

    public void setValidade(String validade) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date data = formato.parse(validade);
            Calendar cal = Calendar.getInstance();
            cal.setTime(data);
            cal.add(Calendar.YEAR, 1);
            this.validade = cal.getTime();
        } catch (ParseException e) {
            System.out.println("Erro ao analisar a data. Por favor, insira a data no formato dd/MM/yyyy.");
        }
    }

    // Método toString para representação em String da classe Produto
    @Override
    public String toString() {
        return "Produto " + codigo + "\n" +
                "Nome= " + nome +
                ", descricao= " + descricao +
                ", preco= " + preco +
                ", validade=" + getValidade();
    }
}
