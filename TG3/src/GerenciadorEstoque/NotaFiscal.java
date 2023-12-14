package GerenciadorEstoque;

import java.io.StringWriter;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * A classe NotaFiscal representa uma transação de venda contendo informações sobre produtos,
 * quantidades, datas e totais.
 *
 *
 * @author Manoela Resende
 * @author Eduarda Sifuentes
 * @see Item
 * @see Produto
 */
public class NotaFiscal {
    /**
     * Contador estático para gerar códigos únicos de notas fiscais.
     */
    private static int contador = 0;

    /**
     * Código único associado à nota fiscal.
    */
    private int codigo;


    /**
     * Data de emissão da nota fiscal.
     */
    private String data;

      /**
     * Lista de itens associados à nota fiscal.
    */
    private List<Item> itens;

    /**
     * Total da nota fiscal.
     */
    private double total;


    /**
     * Construtor da classe NotaFiscal.
     * Inicializa o código, a data, a lista de itens e o total da nota fiscal.
    */

    public NotaFiscal() {
        this.codigo = ++contador;
        this.data = data;
        this.itens = new ArrayList<>();
        this.total = 0.0;
    }

    public NotaFiscal(String data) {
        this.codigo = ++contador;
        this.data = data;
        this.itens = new ArrayList<>();
        this.total = 0.0;
    }

    /**
     * Adiciona um item à nota fiscal.
     *
     * @param produto O produto a ser adicionado à nota fiscal.
     * @param quantidade A quantidade do produto a ser adicionada à nota fiscal (deve ser maior que zero).
     * @throws IllegalArgumentException Se o produto fornecido for nulo ou a quantidade for menor ou igual a zero.
     */
    public void adicionarItem(Produto produto, double quantidade) {
        if (produto == null) {
            throw new IllegalArgumentException("Produto não pode ser nulo.");
        }
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero.");
        }
        Item item = new Item(produto, quantidade);
        this.itens.add(item);
        this.total += produto.getPreco() * quantidade;
    }

    /**
     * Obtém o código único associado à nota fiscal.
     * @return O código único da nota fiscal.
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Obtém a data de emissão da nota fiscal.
     * @return A data de emissão da nota fiscal.
    */
    public String getData() {
        return data;
    }
  
  
    public void setData(String data) {
        this.data = data;
    }


    /**
     * Obtém a lista de itens associados à nota fiscal.
     * @return A lista de itens da nota fiscal.
     */
    public List<Item> getItens() {
        return itens;
    }
    /**
     * Obtém o total da nota fiscal.
     * @return O total da nota fiscal.
     */
    public double getTotal() {
        return total;
    }

    /**
     * Gera uma representação CSV da nota fiscal.
     * @return Uma string no formato CSV representando a nota fiscal.
     */
    public String toCSV() {
        // Adiciona os detalhes da Nota Fiscal
        String csv = codigo + "," + data + "," + total;

        // Adiciona os itens
        for (Item item : itens) {
            csv += "," + item.getProduto().getCodigo() + ":" + item.getQuantidade();
        }

        return csv;
    }

    /**
     * Cria uma instância de NotaFiscal a partir de uma string CSV.
     * @param csv A string CSV contendo informações da nota fiscal.
     * @return Uma nova instância de NotaFiscal criada a partir da string CSV.
     */
     public static NotaFiscal fromCSV(String csv, Estoque estoque) {
        String[] parts = csv.split(",");
        int codigo = Integer.parseInt(parts[0]);
        String data = parts[1];
        double total = Double.parseDouble(parts[2]);

        // Cria uma nova Nota Fiscal
        NotaFiscal nf = new NotaFiscal(data);
        nf.codigo = codigo;
        nf.total = total;


        // Adiciona os itens
        for (int i = 3; i < parts.length; i++) {
            String[] itemParts = parts[i].split(":");
            int codigoProduto = Integer.parseInt(itemParts[0]);
            double quantidade = Double.parseDouble(itemParts[1]);

            // Aqui você deve encontrar o Produto com o código do produto.
            Produto produto = estoque.getProduto(codigoProduto);

            // Cria um novo Item e adiciona à Nota Fiscal
            Item item = new Item(produto, quantidade);
            nf.itens.add(item);
        }

        return nf;
    }


    /**
     * Retorna uma representação em formato de string da nota fiscal, incluindo detalhes sobre
     * produtos, quantidades e totais.
     *
     * @return Uma string formatada representando a nota fiscal.
     */

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.00");
        StringBuilder sb = new StringBuilder();
        sb.append("========================================\n");
        sb.append("NOTA FISCAL Nº: ").append(codigo).append("\n");
        sb.append("DATA: ").append(data).append("\n");
        sb.append("----------------------------------------\n");
        sb.append("ITENS:\n");
        for (Item item : itens) {
            sb.append("Produto: ").append(item.getProduto().getNome()).append("\n");
            sb.append("Quantidade: ").append(item.getQuantidade()).append("\n");
            sb.append("Preço Unitario/Kg: R$").append(item.getProduto().getPreco()).append("\n");
            double subtotal = item.getProduto().getPreco() * item.getQuantidade();
            sb.append("Subtotal: R$").append(df.format(subtotal)).append("\n");
            sb.append("----------------------------------------\n");
        }
        sb.append("TOTAL: R$").append(df.format(total)).append("\n");
        sb.append("========================================");
        return sb.toString();
    }
}
