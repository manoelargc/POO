package GerenciadorEstoque;

public class ProdutoKG extends Produto {
    private double quantidade;

    public ProdutoKG(String nome, String descricao, double preco, double quantidade) throws IllegalArgumentException {
        super(nome, descricao, preco);
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero.");
        }
        this.quantidade = quantidade;
    }

    public double getQuantidade() {
        return quantidade;
    }

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
     * Método toString para representação em String da classe ProdutoKG
     *
     * @return Uma representação pra retornar em String os atributos de ProdutoKG
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
