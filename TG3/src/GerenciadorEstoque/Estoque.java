package GerenciadorEstoque;

import java.util.ArrayList;
import java.util.List;

/**
* A classe Estoque representa o estoque de produtos em um sistema de gerenciamento.
 * Implementa a interface IProdutos, fornecendo métodos para adicionar, remover, atualizar
 * e acessar informações sobre os produtos presentes no estoque.
 *
 * @author Manoela Resende
 * @author Eduarda Sifuentes
 */
public class Estoque implements IProdutos {
    /**
     * Lista que armazena os produtos presentes no estoque.
     */
    private List<Produto> produtos;

    /**
     * Construtor da classe Estoque.
     * Inicializa a lista de produtos como uma ArrayList vazia.
     */
    public Estoque() {
        this.produtos = new ArrayList<>();
    }

    /**
     * Obtém a lista de produtos no estoque.
     * @return A lista de produtos no estoque.
    */
    public List<Produto> getProdutos() {
        return produtos;
    }

    /**
     * Adiciona um novo produto ao estoque.
     *
     * @param p O produto a ser adicionado.
     * @return true se o produto foi adicionado com sucesso, false se o produto já existe no estoque.
     * @throws IllegalArgumentException Se o produto fornecido for nulo.
     */
    @Override
    public boolean addProduto(Produto p) {
        if (p == null) {
            throw new IllegalArgumentException("Produto não pode ser nulo.");
        }
        for (Produto produto : produtos) {
            if (produto.getCodigo() == p.getCodigo()) {
                return false;
            }
        }
        produtos.add(p);
        return true;
    }

    /**
     * Remove um produto do estoque com base no seu código.
     *
     * @param codigo O código do produto a ser removido.
     * @return true se o produto foi removido com sucesso, false se o produto não foi encontrado no estoque.
     */
    @Override
    public boolean removeProduto(int codigo) {
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                produtos.remove(produto);
                return true;
            }
        }
        return false;
    }

    @Override
    public Produto getProduto(int codigo) {
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                return produto;
            }
        }
        return null;
    }

    /**
     * Atualiza as informações de um produto no estoque com base no seu código.
     *
     * @param codigo O código do produto a ser atualizado.
     * @param novo O novo produto que substituirá o existente.
     * @return true se o produto foi atualizado com sucesso, false se o produto não foi encontrado no estoque.
     */
    @Override
    public boolean updateProduto(int codigo, Produto novo) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getCodigo() == codigo) {
                produtos.set(i, novo);
                return true;
            }
        }
        return false;
    }

    /**
     * Atualiza o preço de um produto no estoque com base no seu código.
     *
     * @param codigo O código do produto a ter o preço atualizado.
     * @param novo O novo preço a ser atribuído ao produto.
     * @return true se o preço foi atualizado com sucesso, false se o produto não foi encontrado no estoque.
    */
    @Override
    public boolean updatePreco(int codigo, double novo) {
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                produto.setPreco(novo);
                return true;
            }
        }
        return false;
    }

    /**
     * Adiciona uma determinada quantidade ao estoque de um produto com base no seu código.
     *
     * @param codigo O código do produto a ter a quantidade adicionada.
     * @param quantidade A quantidade a ser adicionada ao estoque.
     * @return true se a quantidade foi adicionada com sucesso, false se o produto não foi encontrado no estoque.
    */
    @Override
    public boolean addQuantidade(int codigo, double quantidade) {
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                if (produto instanceof ProdutoUN) {
                    ((ProdutoUN) produto).setQuantidade(((ProdutoUN) produto).getQuantidade() + (int) quantidade);
                } else if (produto instanceof ProdutoKG) {
                    ((ProdutoKG) produto).setQuantidade(((ProdutoKG) produto).getQuantidade() + quantidade);
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Subtrai uma determinada quantidade do estoque de um produto com base no seu código.
     *
     * @param codigo O código do produto a ter a quantidade subtraída.
     * @param quantidade A quantidade a ser subtraída do estoque.
     * @return true se a quantidade foi subtraída com sucesso, false se o produto não foi encontrado no estoque
     *         ou se a quantidade a ser subtraída é maior do que a quantidade presente no estoque.
     */
    @Override
    public boolean subQuantidade(int codigo, double quantidade) {
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                if (produto instanceof ProdutoUN) {
                    int novaQuantidade = (int) (((ProdutoUN) produto).getQuantidade() - (double) quantidade);
                    if (novaQuantidade < 0) {
                        return false;
                    }
                    ((ProdutoUN) produto).setQuantidade(novaQuantidade);
                } else if (produto instanceof ProdutoKG) {
                    double novaQuantidade = ((ProdutoKG) produto).getQuantidade() - quantidade;
                    if (novaQuantidade < 0) {
                        return false;
                    }
                    ((ProdutoKG) produto).setQuantidade(novaQuantidade);
                }
                return true;
            }
        }
        return false;
    }
}
