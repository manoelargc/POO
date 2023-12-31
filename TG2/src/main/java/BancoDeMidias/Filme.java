package BancoDeMidias;

import java.util.Arrays;

/**
 * Classe que representa um filme, estendendo a classe Multimidia.
 *
 * @author Manoela Resende
 * @author Eduarda Sifuentes
 */

public class Filme extends Multimidia {
    //atributos
    private String diretor;
    private int num;
    private String[] atores;

    /**
     * metodo construtor de filme
     * @param titulo: título do filme
     * @param genero: gênero do filme
     */
    public Filme(String titulo, String genero) {
        super(titulo, genero);
    }

    //metodos especiais
    //get e set

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

    /**
     * @return tipo de midia pra classificar as tabelas no app da interface do usuario
     */
    @Override
    public String getTipo() {
        return "Filme";
    }

}
