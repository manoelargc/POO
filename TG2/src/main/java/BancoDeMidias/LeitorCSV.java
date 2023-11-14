package BancoDeMidias;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeitorCSV {
    public ListaEncadeada<Midia> lerArquivo(String nomeArquivo) {
        ListaEncadeada<Midia> midias = new ListaEncadeada<>();

        try {
            File file = new File(nomeArquivo);
            Scanner scanner = new Scanner(file);

/*            // Pula o cabeçalho do CSV
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }*/

            // Lê as linhas do arquivo
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] campos = linha.split(",");

                // O primeiro campo é o tipo de mídia
                String tipo = campos[0];

                // Cria um novo objeto de mídia com base no tipo
                if (tipo.equals("Foto")) {
                    midias.add(criarFoto(campos));
                } else if (tipo.equals("Filme")) {
                    midias.add(criarFilme(campos));
                } else if (tipo.equals("Musica")) {
                    midias.add(criarMusica(campos));
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("O arquivo não foi encontrado.");
            e.printStackTrace();
        }

        return midias;
    }

    //arrumar metodo: mudar loc do ano,, verfic param data, posicoes
    private Foto criarFoto(String[] campos) {
        Foto foto = new Foto(campos[1], campos[2]);
        foto.setDescricao(campos[3]);
        foto.setFotografo(campos[4]);
        foto.setPessoas(campos[5].split(";")); // Divide a lista de pessoas usando o ponto e vírgula como delimitador
        foto.setLocal(campos[6]);
        foto.setData(Integer.parseInt(campos[7]), Integer.parseInt(campos[8]), Integer.parseInt(campos[9]));
        foto.setImageUrl(campos[8]); // Adiciona o link da imagem
        return foto;
    }

    private Filme criarFilme(String[] campos) {
        Filme filme = new Filme(campos[1], campos[5]);
        filme.setDescricao(campos[2]);
        filme.setAno(Integer.parseInt(campos[3]));
        filme.setIdioma(campos[4]);
        filme.setDuracao(Integer.parseInt(campos[5]),Integer.parseInt(campos[6]),Integer.parseInt(campos[7]));
        filme.setDiretor(campos[8]);
        filme.setAtores(campos[9]);
        filme.setImageUrl(campos[10]); // Adiciona o link da imagem
        return filme;
    }

    private Musica criarMusica(String[] campos) {
        Musica musica = new Musica(campos[1], campos[4]);
        musica.setAno(Integer.parseInt(campos[2]));
        musica.setDescricao(campos[3]);
        musica.setIdioma(campos[4]);
        musica.setDuracao(Integer.parseInt(campos[5]),Integer.parseInt(campos[6]),Integer.parseInt(campos[7]));
        musica.setCompositores(campos[8]);
        musica.setInterpretes(campos[9]);
        musica.setImageUrl(campos[10]); // Adiciona o link da imagem
        return musica;
    }

}
