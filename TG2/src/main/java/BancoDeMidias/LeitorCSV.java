package BancoDeMidias;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;


public class LeitorCSV {

        public ListaEncadeada<Midia> lerArquivo(String nomeArquivo) {
            ListaEncadeada<Midia> midias = new ListaEncadeada<>();

            try {
                File file = new File(nomeArquivo);
                BufferedReader br = new BufferedReader(new FileReader(file));
                String linha;
                while ((linha = br.readLine()) != null) {
                    String[] campos = linha.split("#");

                    // O primeiro campo é o tipo de mídia
                    String tipo = campos[0];

                    // Cria um novo objeto de mídia com base no tipo
                    if (tipo.equals("Foto")) {
                        criarFoto(campos);
                    } else if (tipo.equals("Filme")) {
                        criarFilme(campos);
                        System.out.println(criarFilme(campos));
                    } else if (tipo.equals("Musica")) {
                        criarMusica(campos);
                    }

//                    // Imprime os campos para depuração
//                    System.out.println("Array de Mídias: ");
//                    System.out.println(Arrays.toString(campos));

                }

                br.close();
            } catch (FileNotFoundException e) {
                System.out.println("O arquivo não foi encontrado.");
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("Erro ao ler o arquivo.");
                e.printStackTrace();
            }

            return midias;
        }

    private Foto criarFoto(String[] campos) {
        Foto foto = new Foto(campos[1], Integer.parseInt(campos[7]), Integer.parseInt(campos[8]), Integer.parseInt(campos[3]));
        foto.setDescricao(campos[2]);
        foto.setFotografo(campos[4]);
        foto.setPessoas(campos[5].split(";"));
        foto.setLocal(campos[6]);
        foto.setImageUrl(campos[9]);


        if (campos.length > 9) {
            foto.setImageUrl(campos[9]);
        }

        return foto;
    }

    private Filme criarFilme(String[] campos) {
        Filme filme = new Filme(campos[1], campos[4]);
        filme.setDescricao(campos[2]);
        filme.setAno(Integer.parseInt(campos[3]));
        filme.setIdioma(campos[5]);
        filme.setDuracao(Integer.parseInt(campos[6]), Integer.parseInt(campos[7]), Integer.parseInt(campos[8]));
        filme.setDiretor(campos[9]);
        filme.setAtores(campos[10].split(";"));
        filme.setImageUrl(campos[11]);

        return filme;
    }

    private Musica criarMusica(String[] campos) {
        Musica musica = new Musica(campos[1], campos[4]);
        musica.setDescricao(campos[2]);
        musica.setAno(Integer.parseInt(campos[3]));
        musica.setIdioma(campos[5]);
        musica.setDuracao(Integer.parseInt(campos[6]), Integer.parseInt(campos[7]), Integer.parseInt(campos[8]));
        musica.setCompositores(campos[9].split(";"));
        musica.setInterpretes(campos[10].split(";"));
        musica.setImageUrl(campos[11]);

        return musica;
    }
    void testarLeituraEInsercao() {
        Catalogo catalogo = new Catalogo();
        ListaEncadeada<Midia> midias = lerArquivo("C:\\\\Users\\\\manor\\\\OneDrive\\\\Documentos\\\\GitHub\\\\POO\\\\TG2\\\\src\\\\main\\\\java\\\\BancoDeMidias\\\\CSV\\\\tst.txt");

        if (midias.estaVazia()) {
            System.out.println("Nenhuma mídia foi lida do arquivo.");
            return;
        }

        System.out.println("Mídias lidas do arquivo:");

        IteratorListaEncadeada<Midia> iterator = midias.getIterator();
        while (iterator.temProximo()) {
            Midia midia = iterator.getProximo().getValor();
            System.out.println("Lendo: " + midia.getTitulo());
            catalogo.insere(midia);
        }

        System.out.println("\nCatálogo após a inserção:");

        // Mostrar o catálogo após a inserção
        catalogo.mostra();
    }


}

