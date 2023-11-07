package BancoDeMidias;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/*

public class Catalogo implements ICatalogo {
    // atributos

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

    }

    public void mostra() {

    }

    public Midia consulta(String titulo) {
    }


    public void editar(String titulo, Midia novaMidia) {

    }

    public void delete(String titulo) {

    }
}

*/
