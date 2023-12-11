package GerenciadorEstoque;

public class Item {
    private Produto produto;
    private double quantidade;

    public Item(Produto produto, double quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public double getQuantidade() {
        return quantidade;
    }
}

