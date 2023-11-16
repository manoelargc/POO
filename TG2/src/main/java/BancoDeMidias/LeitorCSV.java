package BancoDeMidias;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Classe responsável por ler um arquivo CSV e criar uma lista encadeada de mídias com base nas informações do arquivo.
 *
 * @author Manoela Resende
 * @author Eduarda Sifuentes
 */

public class LeitorCSV{

    /**
     * Lê um arquivo CSV e cria uma lista encadeada de mídias com base nas informações do arquivo.
     *
     * @param nomeArquivo O caminho do arquivo CSV a ser lido.
     * @return Uma lista encadeada contendo as mídias lidas do arquivo.
     */
        public ListaEncadeada<Midia> lerArquivo(String nomeArquivo) {
            ListaEncadeada<Midia> midias = new ListaEncadeada<>();

            try {
                // Utiliza um BufferedReader para ler o conteúdo do arquivo linha por linha.
                File file = new File(nomeArquivo);
                BufferedReader br = new BufferedReader(new FileReader(file));
                String linha;
                //Lê cada linha do arquivo e cria objetos de mídia com base nos campos.
                while ((linha = br.readLine()) != null) {
                    String[] campos = linha.split("#");

                    // O primeiro campo é o tipo de mídia
                    String tipo = campos[0];

                    // Cria um novo objeto de mídia com base no tipo
                    if (tipo.equals("Foto")) {
                        midias.add(criarFoto(campos));
                    } else if (tipo.equals("Filme")) {
                        midias.add(criarFilme(campos));
                        //System.out.println(criarFilme(campos));
                    } else if (tipo.equals("Musica")) {
                        midias.add(criarMusica(campos));
                    }

                    //Imprime os campos para depuração
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

            //System.out.println("midias: " + midias.toString());
            return midias;
        }



    /**
     * Cria e inicializa um objeto da classe Foto com base nos campos fornecidos.
     *
     * @param campos Os campos necessários para criar a Foto.
     * @return Uma instância da classe Foto.
     */
    protected static Foto criarFoto(String[] campos) {
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


    /**
     * Cria e inicializa um objeto da classe Filme com base nos campos fornecidos.
     *
     * @param campos Os campos necessários para criar o Filme.
     * @return Uma instância da classe Filme.
     */
    protected static Filme criarFilme(String[] campos) {
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

    /**
     * Cria e inicializa um objeto da classe Musica com base nos campos fornecidos.
     *
     * @param campos Os campos necessários para criar a Musica.
     * @return Uma instância da classe Musica.
     */

    protected static Musica criarMusica(String[] campos) {
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

}

