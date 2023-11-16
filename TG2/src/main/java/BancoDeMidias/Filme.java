package BancoDeMidias;

import java.util.Arrays;
/**
 * Classe que representa um filme, estendendo a classe Multimidia.
 * 
 * @author Manoela Resende
 * @author Eduarda Sifuentes
 */

public class Filme extends Multimidia {
    //ATRIBUTOS
    private String diretor;
    private int num;
    private String[] atores;


    /**
    * @param titulo: título do filme
    * @param genero: gênero do filme
    */

    public Filme(String titulo, String genero) {
        super(titulo, genero);
    }

    //GETTERS E SETTERS
    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String[] getAtores() {
        return atores;
    }

    public void setAtores(String[] atores) {
        this.atores = atores;
        this.num= atores.length;
    }

     /**
     * @return Uma representação em String da classe filme, juntando
     * com as informações da classe midia
     */
    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Diretor: " + getDiretor() + "\n" +
                "Atores Principais: " + Arrays.toString(getAtores());
    }

}
