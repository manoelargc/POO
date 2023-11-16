package BancoDeMidias;

/**
 * Interface IListaEncadeada define um conjunto de operações a serem realizadas em uma lista encadeada.
 * Pode adicionar e remover elementos, obter nós em posições específicas,
 * acessar informações sobre o tamanho, o primeiro e o último nó da lista, e criar um iterador para percorrer os elementos.
 *
 * @param <TIPO> O tipo de elementos armazenados na lista.
 * 
 * @author Manoela Resende
 * @author Eduarda Sifuentes
*/

public interface IListaEncadeada<TIPO> {
    
    /**
     * Adiciona um novo valor à lista encadeada.
     *
     * @param novoValor O valor a ser adicionado.
     */
    void add(TIPO novoValor);

    /**
     * Remove um valor da lista encadeada com base no valor procurado.
     *
     * @param valorProcurado O valor a ser procurado e removido na lista.
     */
    void remove(TIPO valorProcurado);

    /**
     * Obtém o nó correspondente à posição fornecida na lista encadeada.
     *
     * @param posicao A posição do nó na lista encadeada.
     * @return O nó correspondente à posição fornecida.
     */
    Nodo<TIPO> get(int posicao);

    /**
     * Obtém o tamanho da lista encadeada.
     *
     * @return O tamanho da lista.
     */
    int getTamanho();

    /**
     * Obtém o primeiro nó da lista encadeada.
     *
     * @return O primeiro nó da lista.
     */
    Nodo<TIPO> getPrimeiro();

    /**
     * Obtém o último nó da lista encadeada.
     *
     * @return O último nó da lista.
     */
    Nodo<TIPO> getUltimo();

    /**
     * Obtém um iterador para percorrer a lista encadeada.
     *
     * @return Um iterador para a lista encadeada.
     */
    IteratorListaEncadeada<TIPO> getIterator();

    /**
     * Configura o primeiro nó da lista encadeada.
     *
     * @param proximo O novo primeiro nó.
     */
    void setPrimeiro(Nodo<TIPO> proximo);

    /**
     * Configura o último nó da lista encadeada.
     *
     * @param anterior O novo último nó.
     */
    void setUltimo(Nodo<TIPO> anterior);

    /**
     * Configura o tamanho da lista encadeada.
     *
     * @param tamanho O novo tamanho da lista.
     */
    void setTamanho(int tamanho);

    /**
     * Verifica se a lista encadeada está vazia.
     *
     * @return true se a lista estiver vazia, false caso contrário.
     */
    boolean estaVazia();
}
