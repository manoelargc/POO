package GerenciadorEstoque;

import java.io.StringWriter;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NotaFiscal {
    private static int contador = 0;
    private int codigo;
    private String data;
    private List<Item> itens;
    private double total;

    //default
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

    public int getCodigo() {
        return codigo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<Item> getItens() {
        return itens;
    }

    public double getTotal() {
        return total;
    }

    public String toCSV() {
        // Adiciona os detalhes da Nota Fiscal
        String csv = codigo + "," + data + "," + total;

        // Adiciona os itens
        for (Item item : itens) {
            csv += "," + item.getProduto().getCodigo() + ":" + item.getQuantidade();
        }

        return csv;
    }

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
