package GerenciadorEstoque;

import java.util.ArrayList;
import java.util.List;

public class Estoque implements IProdutos {
    private List<Produto> produtos;

    public Estoque() {
        this.produtos = new ArrayList<>();
    }

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

    @Override
    public boolean subQuantidade(int codigo, double quantidade) {
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                if (produto instanceof ProdutoUN) {
                    int novaQuantidade = ((ProdutoUN) produto).getQuantidade() - (int) quantidade;
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
