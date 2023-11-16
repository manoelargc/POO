package BancoDeMidias;

/**
 *
 * Classe da Estrutura de dados utilizado
 * A classe ListaEncadeada representa uma lista encadeada genérica e implementa a interface IListaEncadeada.
 * Ela oferece operações como adição, remoção, obtenção de elementos em posições específicas e acesso a informações sobre a lista.
 *
 * @param <TIPO> O tipo genérico da lista encadeada.
 *
 * @author Manoela Resende
 * @author Eduarda Sifuentes
 */
public class ListaEncadeada<TIPO> implements IListaEncadeada<TIPO> {
    private Nodo<TIPO> primeiro;
    private Nodo<TIPO> ultimo;
    private int tamanho;


    /**
     * O construtor da classe inicializa o tamanho da lista como zero, indicando uma lista vazia.
     */
    public ListaEncadeada(){
        this.tamanho = 0;
    }


    //getters e setters
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


    /**
     * Adiciona um novo valor à lista encadeada. Cria um novo nó com o valor fornecido e o adiciona ao final da lista.
     *
     * @param novoValor O valor a ser adicionado à lista.
     */
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


    /**
     * Verifica se a lista encadeada está vazia.
     *
     * @return true se a lista estiver vazia, false caso contrário.
     */
    @Override
    public boolean estaVazia() {
        return getPrimeiro() == null;
    }


    /**
     * Remove um valor da lista encadeada com base no valor procurado. Realiza diferentes ações dependendo da posição do nó na lista.
     * - Se for o primeiro nó, o nó primeiro é atualizado para apontar para o próximo nó, e o nó atual é desconectado.
     * - Se for o último nó, o nó último é ajustado para o nó anterior, e o nó atual é desconectado.
     * - Para demais casos, o nó anterior é configurado para apontar para o próximo nó do nó atual, e o nó atual é desconectado.
     *
     * @param valorProcurado O valor a ser procurado e removido na lista.
     */
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


    /**
     * Obtém o nó correspondente à posição fornecida na lista encadeada.
     *
     * @param posicao A posição do nó a ser obtido.
     * @return O nó na posição especificada.
     */
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

    /**
     * Obtém um iterador para percorrer a lista encadeada.
     *
     * @return Um iterador para a lista encadeada.
     */
    public IteratorListaEncadeada<TIPO> getIterator(){
        return new IteratorListaEncadeada<TIPO>(this.primeiro);
    }
}