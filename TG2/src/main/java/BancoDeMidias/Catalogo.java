package BancoDeMidias;
public class Catalogo implements ICatalogo {
    private IListaEncadeada<Midia> midias;

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
    public Midia consultaPorTitulo(String titulo) {
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
        Nodo<Midia> anterior = null;
        Nodo<Midia> atual = midias.getPrimeiro();
        while (atual != null) {
            Midia midia = atual.getValor();
            if (midia.getTitulo().equalsIgnoreCase(titulo)) {
                if (atual == midias.getPrimeiro()) {
                    midias.setPrimeiro(atual.getProximo());
                } else if (atual == midias.getUltimo()) {
                    midias.setUltimo(anterior);
                    anterior.setProximo(null);
                } else {
                    anterior.setProximo(atual.getProximo());
                }
                midias.setTamanho(midias.getTamanho() - 1);
                return;
            }
            anterior = atual;
            atual = atual.getProximo();
        }
    }


    public IListaEncadeada<Midia> consultaPorData(String data) {
        IListaEncadeada<Midia> resultado = new ListaEncadeada<>();
        IteratorListaEncadeada<Midia> iterator = midias.getIterator();
        while (iterator.temProximo()) {
            Midia midia = iterator.getProximo().getValor();
            if (midia instanceof Foto) {
                Foto foto = (Foto) midia;
                if (foto.data().equalsIgnoreCase(data)) {
                    resultado.add(foto);
                }
            }
        }
        return resultado; // Retorna uma lista de fotos com a data correspondente
    }

    public IListaEncadeada<Midia> consultaPorGenero(String genero) {
        IListaEncadeada<Midia> resultado = new ListaEncadeada<>();
        IteratorListaEncadeada<Midia> iterator = midias.getIterator();
        while (iterator.temProximo()) {
            Midia midia = iterator.getProximo().getValor();
            if (midia instanceof Multimidia) {
                Multimidia multimidia = (Multimidia) midia;
                if (multimidia.getGenero().equalsIgnoreCase(genero)) {
                    resultado.add(multimidia);
                }
            }
        }
        return resultado; // Retorna uma lista de multimídias com o gênero correspondente
    }


}
