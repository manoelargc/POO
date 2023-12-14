package GerenciadorEstoque;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
* A classe GerenciadorNF é responsável por gerenciar as notas fiscais em um sistema de vendas.
 * Implementa a interface INotasFiscais, fornecendo métodos para adicionar, remover, atualizar e
 * acessar informações sobre as notas fiscais emitidas.
 *
 * @author Manoela Resende
 * @author Eduarda Sifuentes
 */
public class GerenciadorNF implements INotasFiscais {
     /**
     * Lista que armazena as notas fiscais gerenciadas pela classe.
     */
    private List<NotaFiscal> notasFiscais;

     /**
     * Construtor da classe GerenciadorNF.
     * Inicializa a lista de notas fiscais como uma ArrayList vazia.
     */
    public GerenciadorNF() {
        this.notasFiscais = new ArrayList<>();
    }

    /**
     * Obtém a lista de notas fiscais gerenciadas.
     * @return A lista de notas fiscais.
     */
    public List<NotaFiscal> getNotasFiscais() {
        return notasFiscais;
    }

    /**
     * Adiciona uma nova nota fiscal à lista.
     *
     * @param nf A nota fiscal a ser adicionada.
     * @return true se a nota fiscal foi adicionada com sucesso, false se a nota fiscal já existe na lista.
     * @throws IllegalArgumentException Se a nota fiscal fornecida for nula.
     */
    @Override
    public boolean addNotaFiscal(NotaFiscal nf) {
        if (nf == null) {
            throw new IllegalArgumentException("Nota fiscal não pode ser nula.");
        }
        return notasFiscais.add(nf);
    }

    /**
     * Remove uma nota fiscal da lista com base no seu código.
     *
     * @param codigo O código da nota fiscal a ser removida.
     * @return true se a nota fiscal foi removida com sucesso, false se a nota fiscal não foi encontrada.
     */
    @Override
    public boolean removeNotaFiscal(int codigo) {
        return notasFiscais.removeIf(nf -> nf.getCodigo() == codigo);
    }

    /**
     * Obtém uma nota fiscal da lista com base no seu código.
     *
     * @param codigo O código da nota fiscal a ser obtida.
     * @return A nota fiscal correspondente ao código fornecido, ou null se a nota fiscal não foi encontrada.
     */
    @Override
    public NotaFiscal getNotaFiscal(int codigo) {
        for (NotaFiscal nf : notasFiscais) {
            if (nf.getCodigo() == codigo) {
                return nf;
            }
        }
        return null;
    }

     /**
     * Atualiza as informações de uma nota fiscal na lista com base no seu código.
     *
     * @param codigo O código da nota fiscal a ser atualizada.
     * @param nova A nova nota fiscal que substituirá a existente.
     * @return true se a nota fiscal foi atualizada com sucesso, false se a nota fiscal não foi encontrada.
     */
    @Override
    public boolean updateNotaFiscal(int codigo, NotaFiscal nova) {
        for (int i = 0; i < notasFiscais.size(); i++) {
            if (notasFiscais.get(i).getCodigo() == codigo) {
                notasFiscais.set(i, nova);
                return true;
            }
        }
        return false;
    }

    /**
     * Adiciona um item a uma nota fiscal com base no seu código.
     *
     * @param codigo O código da nota fiscal à qual o item será adicionado.
     * @param item O item a ser adicionado.
     * @return true se o item foi adicionado com sucesso, false se a nota fiscal não foi encontrada.
     */
    @Override
    public boolean addItem(int codigo, Item item) {
        NotaFiscal nf = getNotaFiscal(codigo);
        if (nf != null) {
            nf.adicionarItem(item.getProduto(), item.getQuantidade());
            return true;
        }
        return false;
    }

    /**
     * Remove um item de uma nota fiscal com base no seu código.
     *
     * @param codigo O código da nota fiscal da qual o item será removido.
     * @param item O item a ser removido.
     * @return true se o item foi removido com sucesso, false se a nota fiscal ou o item não foram encontrados.
     */
    @Override
    public boolean removeItem(int codigo, Item item) {
        NotaFiscal nf = getNotaFiscal(codigo);
        if (nf != null) {
            return nf.getItens().remove(item);
        }
        return false;
    }

    public double getTotalVendido() {
        double total = 0;
        for (NotaFiscal nf : notasFiscais) {
            total += nf.getTotal();
        }
        return total;
    }

    /**
     * Calcula o total vendido em uma data específica.
     *
     * @param data A data para a qual o total vendido será calculado (formato "dd/MM/yyyy").
     * @return O total vendido na data especificada.
     * @throws ParseException Se ocorrer um erro ao analisar a string de data.
     */
    public double getTotalVendido(String data) throws ParseException {
        double total = 0.0;

        // Converte a string de data para um objeto Date
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        Date dataDate = formatador.parse(data);

        // Percorre todas as Notas Fiscais
        for (NotaFiscal nf : notasFiscais) {
            // Compara a data da Nota Fiscal com a data fornecida
            if (nf.getData().equals(dataDate)) {
                // Adiciona o total da Nota Fiscal ao total geral
                total += nf.getTotal();
            }
        }

        return total;
    }

     /**
     * Calcula o total vendido em um período específico.
     *
     * @param dataInicio A data de início do período.
     * @param dataFim A data de fim do período.
     * @return O total vendido no período especificado.
     */
    public double getTotalVendido(Date dataInicio, Date dataFim) {
        double total = 0;
        for (NotaFiscal nf : notasFiscais) {
            if (nf.getData().compareTo(dataInicio) >= 0 && nf.getData().compareTo(dataFim) <= 0) {
                total += nf.getTotal();
            }
        }
        return total;
    }

    /**
     * Retorna uma representação em formato de string da classe, exibindo as informações de cada nota fiscal.
     * @return Uma string contendo as informações das notas fiscais.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (NotaFiscal nf : notasFiscais) {
            sb.append(nf.toString()).append("\n");
        }
        return sb.toString();
    }

}
