package BancoDeMidias;
/**
 * Classe que representa um nó em uma lista encadeada.
 *
 * @param <TIPO> O tipo de valor armazenado no nó.
 *
 * @author Manoela Resende
 * @author Eduarda Sifuentes
 */

public class Nodo<TIPO> {
    private TIPO valor;
    private Nodo<TIPO> proximo;

    /**
     * Construtor da classe Nodo.
     *
     * @param novoValor O novo valor a ser armazenado no nó.
     */
    public Nodo(TIPO novoValor){
        this.valor = novoValor;
    }


    //getters e setters
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