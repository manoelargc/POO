package BancoDeMidias;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Catalogo implements ICatalogo {
    // atributos
    private Nodo raiz; // Raiz da árvore


    // metodos

    public void carregarDeCSV(String nomeArquivo) {
        String linha = "";
        String separadorCSV = ","; // Define o separador do .csv

        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            while ((linha = br.readLine()) != null) {
                // dividir a linha em colunas
                String[] colunas = linha.split(separadorCSV);

                String tipo = colunas[0];
                String titulo = colunas[1];
                String descricao = colunas[2];
                Midia midia;
                switch (tipo) {
                    case "Foto":
                        midia = new Foto();
                        //falta def
                        break;
                    case "Musica":
                        midia = new Musica();
                        //falta def
                        break;
                    case "Filme":
                        midia = new Filme();
                        //falta def
                        break;
                    default:
                        break;
                }
                midia.setTitulo(titulo);
                midia.setDescricao(descricao);
                this.insere(midia);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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

