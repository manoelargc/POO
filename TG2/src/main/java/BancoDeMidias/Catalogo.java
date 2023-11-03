package BancoDeMidias;

public class Catalogo implements ICatalogo {
    // atributos
    private Nodo raiz; // Raiz da árvore

    // metodos
    public void insere(Midia midia) {
        raiz = insereRecursivo(raiz, midia);
    }

    private Nodo insereRecursivo(Nodo atual, Midia midia) {
        if (atual == null) {
            return new Nodo(midia);
        }

        int compare = midia.getTitulo().compareTo(atual.getMidia().getTitulo());

        if (compare < 0) {
            atual.setEsquerda(insereRecursivo(atual.getEsquerda(), midia));
        } else if (compare > 0) {
            atual.setDireita(insereRecursivo(atual.getDireita(), midia));
        }

        return atual;
    }

    public void mostra() {
        mostraRecursivo(raiz);
    }

    private void mostraRecursivo(Nodo atual) {
        if (atual != null) {
            mostraRecursivo(atual.getEsquerda());
            System.out.println(atual.getMidia().getTitulo());
            mostraRecursivo(atual.getDireita());
        }
    }

    public Midia consulta(String titulo) {
        return consultaRecursivo(raiz, titulo);
    }

    private Midia consultaRecursivo(Nodo atual, String titulo) {
        if (atual == null) {
            return null;
        }

        int compare = titulo.compareTo(atual.getMidia().getTitulo());

        if (compare < 0) {
            return consultaRecursivo(atual.getEsquerda(), titulo);
        } else if (compare > 0) {
            return consultaRecursivo(atual.getDireita(), titulo);
        }

        return atual.getMidia();
    }

    public void editar(String titulo, Midia novaMidia) {

    }

    public void delete(String titulo) {

    }
}

