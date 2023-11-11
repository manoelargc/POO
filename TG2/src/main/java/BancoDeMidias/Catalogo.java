package BancoDeMidias;

public class Catalogo implements ICatalogo {
    private ListaEncadeada<Midia> midias;
    //falta ler csv

    public Catalogo() {
        midias = new ListaEncadeada<>();
    }

    @Override
    public void insere(Midia midia) {
        midias.add(midia);
    }

    @Override
    public void mostra() {
        IteratorListaEncadeada<Midia> iterator = midias.getIterator();
        while (iterator.temProximo()) {
            Midia midia = iterator.getProximo().getValor();
            System.out.println(midia.toString()); // Isso imprimirá as informações da mídia
        }
    }

    @Override
    public Midia consulta(String titulo) {
        IteratorListaEncadeada<Midia> iterator = midias.getIterator();
        while (iterator.temProximo()) {
            Midia midia = iterator.getProximo().getValor();
            if (midia.getTitulo().equalsIgnoreCase(titulo)) {
                return midia;
            }
        }
        return null; // Mídia não encontrada
    }

    @Override
    public void editar(String titulo, Midia novaMidia) {
        IteratorListaEncadeada<Midia> iterator = midias.getIterator();
        while (iterator.temProximo()) {
            Midia midia = iterator.getProximo().getValor();
            if (midia.getTitulo().equalsIgnoreCase(titulo)) {
                // Substitua a mídia existente pela nova mídia
                iterator.getProximo().setValor(novaMidia);
                return;
            }
        }
    }

    @Override
    public void delete(String titulo) {
        IteratorListaEncadeada<Midia> iterator = midias.getIterator();
        while (iterator.temProximo()) {
            Midia midia = iterator.getProximo().getValor();
            if (midia.getTitulo().equalsIgnoreCase(titulo)) {
                iterator.getProximo().setValor(null);
                iterator.getProximo().setProximo(null);
                return;
            }
        }
    }
}
