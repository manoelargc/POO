package GerenciadorEstoque;

public class ProdutoUN extends Produto {
    private int quantidade;

    public ProdutoUN(String nome, String descricao, double preco, int quantidade) {
        super(nome, descricao, preco);
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * Método toString para representação em String da classe ProdutoUN
     *
     * @return Uma representação pra retornar em String os atributos de ProdutoUN
     */
    @Override
    public String toString() {
        return super.toString() + ", " +
                "quantidade= " + getQuantidade();
    }
}
