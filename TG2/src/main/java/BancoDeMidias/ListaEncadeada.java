package BancoDeMidias;

public class ListaEncadeada<TIPO> implements IListaEncadeada<TIPO> {
    private Nodo<TIPO> primeiro;
    private Nodo<TIPO> ultimo;
    private int tamanho;

    public ListaEncadeada(){
        this.tamanho = 0;
    }

    @Override
    public Nodo<TIPO> getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(Nodo<TIPO> primeiro) {
        this.primeiro = primeiro;
    }

    @Override
    public Nodo<TIPO> getUltimo() {
        return ultimo;
    }

    public void setUltimo(Nodo<TIPO> ultimo) {
        this.ultimo = ultimo;
    }

    @Override
    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public void add(TIPO novoValor){
        Nodo<TIPO> novoNodo = new Nodo<TIPO>(novoValor);
        if (this.primeiro == null && this.ultimo == null){
            this.primeiro = novoNodo;
            this.ultimo = novoNodo;
        }else{
            this.ultimo.setProximo(novoNodo);
            this.ultimo = novoNodo;
        }
        this.tamanho++;
    }

    @Override
    public boolean estaVazia() {
        return getPrimeiro() == null;
    }

    @Override
    public void remove(TIPO valorProcurado){
        Nodo<TIPO> anterior = null;
        Nodo<TIPO> atual = this.primeiro;
        for(int i=0; i < this.getTamanho(); i++){
            if (atual.getValor().equals(valorProcurado)){
                if (this.tamanho == 1){
                    this.primeiro = null;
                    this.ultimo = null;
                }else if (atual == primeiro){
                    this.primeiro = atual.getProximo();
                    atual.setProximo(null);
                }else if (atual == ultimo){
                    this.ultimo = anterior;
                    anterior.setProximo(null);
                }else{
                    anterior.setProximo(atual.getProximo());
                    atual = null;
                }
                this.tamanho--;
                break;
            }
            anterior = atual;
            atual = atual.getProximo();
        }
    }

    @Override
    public Nodo get(int posicao){
        Nodo atual = this.primeiro;
        for(int i=0; i < posicao; i++){
            if (atual.getProximo() != null){
                atual = atual.getProximo();
            }
        }
        return atual;
    }
    public IteratorListaEncadeada<TIPO> getIterator(){
        return new IteratorListaEncadeada<TIPO>(this.primeiro);
    }
}