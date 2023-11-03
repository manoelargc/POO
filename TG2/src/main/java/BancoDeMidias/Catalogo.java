package BancoDeMidias;

public class Catalogo implements ICatalogo {
    // Atributos
    private Nodo raiz; // Raiz da árvore

    // Métodos
    public void inserir(Midia midia) {
        raiz = inserirRecursivo(raiz, midia);
    }

    private Nodo inserirRecursivo(Nodo atual, Midia midia) {
        if (atual == null) {
            return new Nodo(midia);
        }

        int comparacao = midia.getTitulo().compareTo(atual.getMidia().getTitulo());

        if (comparacao < 0) {
            atual.setEsquerda(inserirRecursivo(atual.getEsquerda(), midia));
        } else if (comparacao > 0) {
            atual.setDireita(inserirRecursivo(atual.getDireita(), midia));
        }

        return atual;
    }

    public void exibir() {
        exibirRecursivo(raiz);
    }

    private void exibirRecursivo(Nodo atual) {
        if (atual != null) {
            exibirRecursivo(atual.getEsquerda());
            System.out.println(atual.getMidia().getTitulo());
            exibirRecursivo(atual.getDireita());
        }
    }

    public Midia consultar(String titulo) {
        return consultarRecursivo(raiz, titulo);
    }

    private Midia consultarRecursivo(Nodo atual, String titulo) {
        if (atual == null) {
            return null;
        }

        int comparacao = titulo.compareTo(atual.getMidia().getTitulo());

        if (comparacao < 0) {
            return consultarRecursivo(atual.getEsquerda(), titulo);
        } else if (comparacao > 0) {
            return consultarRecursivo(atual.getDireita(), titulo);
        }

        return atual.getMidia();
    }

    public void editar(String titulo, Midia novaMidia) {
        // Implementar a edição de uma mídia
    }

    public void excluir(String titulo) {
        // Implementar a exclusão de uma mídia
    }
}
