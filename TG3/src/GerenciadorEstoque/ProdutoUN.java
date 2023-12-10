package GerenciadorEstoque;

public class ProdutoUN extends Produto {
    private int quantidade;

    public ProdutoUN(String nome, String descricao, double preco, int quantidade) throws IllegalArgumentException{
        super(nome, descricao, preco);
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero.");
        }
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

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
     * Método toString para representação em String da classe ProdutoUN
     *
     * @return Uma representação pra retornar em String os atributos de ProdutoUN
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
