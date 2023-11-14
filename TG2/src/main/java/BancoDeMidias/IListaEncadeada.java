package BancoDeMidias;

public interface IListaEncadeada<TIPO> {
    void add(TIPO novoValor);
    void remove(TIPO valorProcurado);
    Nodo<TIPO> get(int posicao);
    int getTamanho();
    Nodo<TIPO> getPrimeiro();
    Nodo<TIPO> getUltimo();
    IteratorListaEncadeada<TIPO> getIterator();

    void setPrimeiro(Nodo<TIPO> proximo);

    void setUltimo(Nodo<TIPO> anterior);

    void setTamanho(int tamanho);
    public boolean estaVazia();
}
