package GerenciadorEstoque;

/**
 * Classe ProdutoKG que representa um produto que é vendido em quilogramas.
 * Esta classe herda da classe Produto.
 *
 *  * @author Manoela Resende
 *  * @author Eduarda Sifuentes
 */
public class ProdutoKG extends Produto {
    private double quantidade;


    /**
     * Construtor padrão/vazio da classe ProdutoKG
     */
    public ProdutoKG() {
        super();
    }

    /**
     * Construtor para a classe ProdutoKG.
     *
     * @param nome       O nome do produto.
     * @param descricao  A descrição do produto.
     * @param preco      O preço do produto.
     * @param quantidade A quantidade do produto em quilogramas.
     * @throws IllegalArgumentException Se a quantidade for menor ou igual a zero.
     */
    public ProdutoKG(String nome, String descricao, double preco, String validade, double quantidade) throws IllegalArgumentException {
        super(nome, descricao, preco, validade, quantidade);
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero.");
        }
        this.quantidade = quantidade;
    }

    /**
     * Retorna a quantidade do produto em quilogramas.
     *
     * @return A quantidade do produto.
     */
    public double getQuantidade() {
        return quantidade;
    }

    /**
     * Define a quantidade do produto.
     *
     * @param quantidade A nova quantidade do produto.
     * @throws IllegalArgumentException Se a quantidade for negativa.
     */
    public void setQuantidade(double quantidade) {
        try {
            if (quantidade < 0) {
                throw new IllegalArgumentException("A quantidade não pode ser negativa.");
            }
            this.quantidade = quantidade;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Retorna uma representação em string do produto.
     *
     * @return Uma representação em string do produto.
     */
    @Override
    public String toString() {
        try {
            return super.toString() + ", " +
                    "quantidade= " + getQuantidade() + "Kg";
        } catch (Exception e) {
            return "Erro ao gerar a representação em string do produto.";
        }
    }
}
