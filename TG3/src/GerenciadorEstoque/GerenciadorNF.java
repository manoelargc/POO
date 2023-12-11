package GerenciadorEstoque;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorNF implements INotasFiscais {
    private List<NotaFiscal> notasFiscais;

    public GerenciadorNF() {
        this.notasFiscais = new ArrayList<>();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (NotaFiscal nf : notasFiscais) {
            sb.append(nf.toString()).append("\n");
        }
        return sb.toString();
    }

}
