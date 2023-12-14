package GerenciadorEstoque;
/**
 * A classe Item representa um produto associado a uma quantidade em um contexto de transação,
 * como uma nota fiscal.
 *
 * @author Manoela Resende
 * @author Eduarda Sifuentes
 */
public class Item {
    /**
     * Produto associado ao item.
     */
    private Produto produto;
    
    /**
     * Quantidade do produto associado.
     */
    private double quantidade;

     /**
     * Construtor da classe Item.
     *
     * @param produto O produto associado ao item.
     * @param quantidade A quantidade do produto associado (deve ser maior que zero).
     * @throws IllegalArgumentException Se o produto fornecido for nulo ou a quantidade for menor ou igual a zero.
     */
    public Item(Produto produto, double quantidade) {
        if (produto == null) {
            throw new IllegalArgumentException("Produto não pode ser nulo.");
        }
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero.");
        }
        this.produto = produto;
        this.quantidade = quantidade;
    }

    /**
     * Obtém o produto associado ao item.
     * @return O produto associado ao item.
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * Obtém a quantidade do produto associado ao item.
     * @return A quantidade do produto associado ao item.
     */
    public double getQuantidade() {
        return quantidade;
    }
}
