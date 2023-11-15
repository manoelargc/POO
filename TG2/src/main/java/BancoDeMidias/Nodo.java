package BancoDeMidias;

public class Nodo<TIPO> {
    private TIPO valor;
    private Nodo<TIPO> proximo;

    public Nodo(TIPO novoValor){
        this.valor = novoValor;
    }

    public TIPO getValor() {
        return valor;
    }

    public void setValor(TIPO valor) {
        this.valor = valor;
    }

    public Nodo<TIPO> getProximo() {
        return proximo;
    }

    public void setProximo(Nodo<TIPO> proximo) {
        this.proximo = proximo;
    }
}