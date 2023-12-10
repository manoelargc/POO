package GerenciadorEstoque;

/**
 * @author Aline
 */
public interface IProdutos {
    /**
     * Adiciona um produto ao estoque.
     * @param p Produto
     * @return True se o produto for incluído com sucesso e False caso contrário.
     */
    public abstract boolean addProduto(Produto p);

    /**
     * Remove o produto com código informado.
     * @param codigo Código do produto a ser removido.
     * @return True se o produto for removido com seucesso e False caso contrário.
     */
    public abstract boolean removeProduto(int codigo);

    /**
     * Captura o produto com o código informado.
     * @param codigo Código do produto a ser capturado.
     * @return O produto com o código informado ou NULL caso produto não seja encontrado.
     */
    public abstract Produto getProduto(int codigo);

    /**
     * Altera o produto com o código informado.
     * @param codigo Código do produto a ser alterado.
     * @param novo Produto com as novas informações.
     * @return True se o produto foi corretamente atualizado e False caso contrário.
     */
    public abstract boolean updateProduto(int codigo, Produto novo);


    /**
     * Altera o preço do produto com o código informado.
     * @param codigo Código do produto a ser alterado.
     * @param novo Novo preço do produto.
     * @return True se o preço foi corretamente atualizado e False caso contrário.
     */
    public abstract boolean updatePreco(int codigo, double novo);

    /**
     * Adiciona a quantidade ao produto com código informado.
     * @param codigo Código do produto a ser alterado.
     * @param quantidade Quantidade a ser acrescentada.
     * @return True se a quantidade for adicionada e False caso contrário. 
     */
    public abstract boolean addQuantidade(int codigo, double quantidade);


    /**
     * Subtrai a quantidade do produto com código informado.
     * @param codigo Código do produto a ser alterado.
     * @param quantidade Quantidade a ser subtraída.
     * @return True se a quantidade for subtraída e False caso contrário. 
     */
    public abstract boolean subQuantidade(int codigo, double quantidade);


}