package Q1.E;

import Q1.D.IListaProdutos;
import Q1.A.Produtos;
import java.util.ArrayList;

public class ListaProdutos implements IListaProdutos {
    private ArrayList<Produtos> produtos;

    public ListaProdutos() {
        super();
        this.produtos = new ArrayList<>();
    }

    public int getTamanho() {
        return this.produtos.size();
    }

    public Produtos getProduto(int index) {
        return this.produtos.get(index);
    }


     //sobreescrevendo metodos abstratos da interface
     @Override
     public void incluir(Produtos _produto) {
         for (Produtos produto : this.produtos) {
             if (produto.getCodigo() == _produto.getCodigo()) {
                 System.out.println("Um produto com o mesmo código já existe.");
                 return;
             }
         }
         this.produtos.add(_produto);
     }


    @Override
    public Produtos consultar(int _codigo) {
        for (Produtos produto : this.produtos) {
            if (produto.getCodigo() == _codigo) {
                return produto;
            }
        }
        return null;
    }


    @Override
    public void remover(int _codigo) {
        for (int i = 0; i < this.produtos.size(); i++) {
            if (this.produtos.get(i).getCodigo() == _codigo) {
                this.produtos.remove(i);
                break;
            }
        }
    }
}
