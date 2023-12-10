package GerenciadorEstoque;


public class ProdutoKG extends Produto {
    private double quantidade;

    public ProdutoKG(String nome, String descricao, double preco, double quantidade) {
        super(nome, descricao, preco);
        this.quantidade = quantidade;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
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
                "quantidade= " + getQuantidade() + "Kg";
    }
}
