package GerenciadorEstoque;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NotaFiscal {
    private static int contador = 0;
    private int codigo;
    private Date data;
    private List<Item> itens;
    private double total;

    public NotaFiscal() {
        this.codigo = ++contador;
        this.data = new Date();
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

    public Date getData() {
        return data;
    }

    public List<Item> getItens() {
        return itens;
    }

    public double getTotal() {
        return total;
    }

    public String toCSV() {
        return codigo + "," + data + "," + total;
    }

    public static NotaFiscal fromCSV(String csv) {
        String[] parts = csv.split(",");
        int codigo = Integer.parseInt(parts[0]);
        String data = parts[1];
        double total = Double.parseDouble(parts[2]);
        return new NotaFiscal();
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
