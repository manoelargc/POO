package GerenciadorEstoque;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GerenciadorNF implements INotasFiscais {
    private List<NotaFiscal> notasFiscais;

    public GerenciadorNF() {
        this.notasFiscais = new ArrayList<>();
    }

    public List<NotaFiscal> getNotasFiscais() {
        return notasFiscais;
    }

    @Override
    public boolean addNotaFiscal(NotaFiscal nf) {
        if (nf == null) {
            throw new IllegalArgumentException("Nota fiscal não pode ser nula.");
        }
        return notasFiscais.add(nf);
    }

    @Override
    public boolean removeNotaFiscal(int codigo) {
        return notasFiscais.removeIf(nf -> nf.getCodigo() == codigo);
    }

    @Override
    public NotaFiscal getNotaFiscal(int codigo) {
        for (NotaFiscal nf : notasFiscais) {
            if (nf.getCodigo() == codigo) {
                return nf;
            }
        }
        return null;
    }

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

    @Override
    public boolean addItem(int codigo, Item item) {
        NotaFiscal nf = getNotaFiscal(codigo);
        if (nf != null) {
            nf.adicionarItem(item.getProduto(), item.getQuantidade());
            return true;
        }
        return false;
    }

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

    public double getTotalVendido(String data) throws ParseException {
        double total = 0;

        // Percorre todas as Notas Fiscais
        for (NotaFiscal nf : notasFiscais) {
            // Compara a data da Nota Fiscal com a data fornecida
            if (nf.getData().equals(data)) {
                total = total + nf.getTotal();
                //System.out.println(total);
            }
        }

        return total;
    }


    public double getTotalVendido(String dataInicio, String dataFim) {
        double total = 0;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); // Ajuste o formato de acordo com o formato de suas datas

        try {
            Date dataInicioDate = formato.parse(dataInicio);
            Date dataFimDate = formato.parse(dataFim);

            for (NotaFiscal nf : notasFiscais) {
                Date dataNotaFiscal = formato.parse(nf.getData());

                if ((dataNotaFiscal.compareTo(dataInicioDate) >= 0) && (dataNotaFiscal.compareTo(dataFimDate) <= 0)) {
                    total += nf.getTotal();
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return total;
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (NotaFiscal nf : notasFiscais) {
            sb.append(nf.toString()).append("\n");
        }
        return sb.toString();
    }

}
