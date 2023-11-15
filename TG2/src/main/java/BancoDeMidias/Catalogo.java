package BancoDeMidias;
public class Catalogo implements ICatalogo {
    private IListaEncadeada<Midia> midias;

    public Catalogo() {
        midias = new ListaEncadeada<>();
    }

    @Override
    public void insere(Midia midia) {
        System.out.println("Inserindo: " + midia.getTitulo());  // Adicione esta linha para depuração
        midias.add(midia);
        if (midias.estaVazia()) {
            System.out.println("A lista está vazia após a inserção.");
        } else {
            System.out.println("Item inserido com sucesso. O tamanho atual do catálogo é: " + midias.getTamanho());
        }
    }


    @Override
    public void mostra() {
        if (!midias.estaVazia()) {
            IteratorListaEncadeada<Midia> iterator = midias.getIterator();
            while (iterator.temProximo()) {
                Midia midia = iterator.getProximo().getValor();
                System.out.println(midia.toString());
            }
        } else {
            System.out.println("O catálogo está vazio.");
        }
    }

    @Override
    public Midia consultaPorTitulo(String titulo) {
        if (!midias.estaVazia()) {
            IteratorListaEncadeada<Midia> iterator = midias.getIterator();
            while (iterator.temProximo()) {
                Midia midia = iterator.getProximo().getValor();
                if (midia.getTitulo().equalsIgnoreCase(titulo)) {
                    return midia;
                }
            }
        } else {
            System.out.println("O catálogo está vazio.");
        }
        return null;
    }

    @Override
    public void editar(String titulo, Midia novaMidia) {
        if (!midias.estaVazia()) {
            IteratorListaEncadeada<Midia> iterator = midias.getIterator();
            while (iterator.temProximo()) {
                Midia midia = iterator.getProximo().getValor();
                if (midia.getTitulo().equalsIgnoreCase(titulo)) {
                    iterator.getProximo().setValor(novaMidia);
                    return;
                }
            }
        } else {
            System.out.println("O catálogo está vazio.");
        }
    }

    @Override
    public void delete(String titulo) {
        if (!midias.estaVazia()) {
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
        } else {
            System.out.println("O catálogo está vazio.");
        }
    }


    public IListaEncadeada<Midia> consultaPorData(String data) {
        IListaEncadeada<Midia> resultado = new ListaEncadeada<>();
        if (!midias.estaVazia()) {
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
        } else {
            System.out.println("O catálogo está vazio.");
        }
        return resultado; // Retorna uma lista de fotos com a data correspondente
    }

    public IListaEncadeada<Midia> consultaPorGenero(String genero) {
        IListaEncadeada<Midia> resultado = new ListaEncadeada<>();
        if (!midias.estaVazia()) {
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
        } else {
            System.out.println("O catálogo está vazio.");
        }
        return resultado; // Retorna uma lista de multimídias com o gênero correspondente
    }
}