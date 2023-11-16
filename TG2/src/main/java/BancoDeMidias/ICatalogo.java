package BancoDeMidias;

/**
 * Define um conjunto de operações a serem realizadas em um catálogo de mídias.
 *
 * @author Manoela Resende
 * @author Eduarda Sifuentes
 */

public interface ICatalogo {
    /**
     * Carrega informações do catálogo a partir de um arquivo.
     *
     * @param path O caminho do arquivo a ser lido.
     */

    public void carregaDados(String path);
    /**
     * Permite adicionar uma nova mídia ao catálogo.
     *
     * @param midia A mídia a ser adicionada.
     */

    void insere(Midia midia);
    /**
     * Exibe as informações do catálogo.
     */

    void mostra();

    /**
     * Possibilita a modificação de informações de uma mídia, identificada pelo título.
     *
     * @param titulo O título da mídia a ser consultada.
     * @return A mídia encontrada.
     */
    Midia consultaPorTitulo(String titulo);


    /**
     * Possibilita a modificação de informações de uma mídia, identificada pelo título, onde
     * o campo a ser alterado e o novo valor são especificados como parâmetros.
     *
     * @param titulo    O título da mídia a ser editada.
     * @param Campo     O campo a ser editado.
     * @param novoValor O novo valor a ser atribuído ao campo.
     */
    void editar(String titulo, String Campo, String novoValor);

    /**
     * Remove uma mídia do catálogo com base no título fornecido.
     *
     * @param titulo O título da mídia a ser removida.
     */
    void delete(String titulo);
}
