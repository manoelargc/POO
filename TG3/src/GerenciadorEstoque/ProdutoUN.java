package GerenciadorEstoque;

/**
 * Classe ProdutoUN que representa um produto que é vendido em unidades.
 * Esta classe herda da classe Produto.
 *
 * @author Manoela Resende
 * @author Eduarda Sifuentes
 */
public class ProdutoUN extends Produto {
    private int quantidade;


    /**
     * Construtor padrão/vazio da classe ProdutoUN
     */
    public ProdutoUN() {
        super();
    }

    /**
     * Construtor para a classe ProdutoUN.
     *
     * @param nome       O nome do produto.
     * @param descricao  A descrição do produto.
     * @param preco      O preço do produto.
     * @param quantidade A quantidade do produto em unidades.
     * @throws IllegalArgumentException Se a quantidade for menor ou igual a zero.
     */
    public ProdutoUN(String nome, String descricao, double preco, int quantidade) throws IllegalArgumentException{
        super(nome, descricao, preco, quantidade);
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero.");
        }
        this.quantidade = quantidade;
    }

    /**
     * Retorna a quantidade do produto em unidades.
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
    public void setQuantidade(int quantidade) {
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
                    "quantidade= " + getQuantidade();
        } catch (Exception e) {
            return "Erro ao gerar a representação em string do produto.";
        }
    }
}
