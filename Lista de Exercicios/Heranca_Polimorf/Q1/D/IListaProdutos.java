package Q1.D;

import Q1.A.Produtos;

public interface IListaProdutos {

    //metodos abstratos
    public abstract void incluir(Produtos _produto);
    public abstract Produtos consultar(int _codigo);
    public abstract void remover(int _codigo);

}
