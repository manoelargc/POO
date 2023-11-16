package BancoDeMidias;

/**
 * Classe IteratorListaEncadeada representa um iterador para percorrer a estrutura de dados
 *
 * @param <TIPO> O tipo de elementos armazenados na lista.
 *
 * @author Manoela Resende
 * @author Eduarda Sifuentes
 */
public class IteratorListaEncadeada<TIPO> {
        private Nodo<TIPO> nodo;

    /**
     * Construtor da classe IteratorListaEncadeada.
     * Inicializa o iterador com um nó inicial fornecido como argumento.
     *
     * @param atual O nó inicial para iniciar o iterador.
     */
        public IteratorListaEncadeada(Nodo<TIPO> atual){
            this.nodo = atual;
        }


    /**
     * Verifica se há um próximo nó na lista encadeada.
     * Retorna true se o próximo nó não for nulo, indicando que ainda há elementos a percorrer.
     * Retorna false se o nó atual for nulo, significando que não há mais elementos.
     *
     * @return true se há um próximo nó, false caso contrário.
     */
    public boolean temProximo() {
        if (this.nodo == null) {
            return false;
        } else {
            return this.nodo.getProximo() != null;
        }
    }


    /**
     * Avança para o próximo nó na sequência e retorna esse novo nó.
     *
     * @return O próximo nó na sequência.
     */
        public Nodo<TIPO> getProximo(){
            nodo = nodo.getProximo();
            return nodo;
        }
}
