package GerenciadorEstoque;

/**
 * Interface que especifica os métodos míninos para manipular o conunto de notas fiscais.
 * @author Aline Mello
 */
public interface INotasFiscais {

    /**
     * Adiciona uma nota fiscal.
     * @param nf Nota fiscal a ser adicionada.
     * @return True se a nota for incluída com sucesso e False caso contrário.
     */
    public abstract boolean addNotaFiscal(NotaFiscal nf);

    /**
     * Remove a nota fiscal com código informado.
     * @param codigo Código da nota fiscal a ser removida.
     * @return True se a nota for removida com sucesso e False caso contrário.
     */
    public abstract boolean removeNotaFiscal(int codigo);

    /**
     * Captura a nota fiscal com a nota fiscal informada.
     * @param codigo Código da nota fiscal a ser capturada.
     * @return A nota fiscal com o código informado ou NULL caso a nota fiscal não seja encontrada.
     */
    public abstract NotaFiscal getNotaFiscal(int codigo);

    /**
     * Altera a nota fiscal com o código informado.
     * @param codigo Código da nota fiscal a ser alterada.
     * @param nova Nota fiscal com as novas informações.
     * @return True se a nota fiscal foi corretamente atualizada e False caso contrário.
     */
    public abstract boolean updateNotaFiscal(int codigo, NotaFiscal nova);


    /**
     * Adiciona um item a nota fiscal com o código informado.
     * @param codigo Código da nota fiscal na qual o item deve ser adicionado.
     * @param item Item a ser adicionado.
     * @return True caso o item foi adicionado com sucesso e False caso a nota fiscal não exista ou a quantidade do produto em estoque seja menos do que a solicitada.
     */
    public boolean addItem(int codigo, Item item);

    /**
     * Remove um item da nota fiscal com o código informado.
     * @param codigo Código da nota fiscal na qual o item deve ser removido.
     * @param item Item a ser removido.
     * @return True caso o item foi removido com sucesso e False caso contrário.
     */
    public boolean removeItem(int codigo, Item item);
}