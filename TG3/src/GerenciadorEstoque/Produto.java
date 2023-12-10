package GerenciadorEstoque;

import java.util.Calendar;
import java.util.Date;

public class Produto {

//atributos

    private static int contador = 1;
    private int codigo;
    private String nome;
    private String descricao;
    private double preco;
    private Date validade;

    //construtor
    public Produto(String nome, String descricao, double preco) {
        this.codigo = ++contador;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;

        // Cria uma data atual
        Calendar cal = Calendar.getInstance();
        // Adiciona um ano à data atual
        cal.add(Calendar.YEAR, 1);
        // Define a data de validade como um ano a partir da data atual
        this.validade = cal.getTime();
    }

    //get e set

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

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }


    /**
     * Método toString para representação em String da classe Produto
     *
     * @return Uma representação pra retornar em String os atributos de Produto
     */
    @Override
    public String toString() {
        return "Produto " + codigo + "\n" +
                "Nome= " + nome +
                ", descricao= " + descricao +
                ", preco= " + preco +
                ", validade= " + validade;
    }


}


