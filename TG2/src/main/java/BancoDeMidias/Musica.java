package BancoDeMidias;

import java.util.Arrays;


/**
 * Classe que representa uma música, estendendo a classe Multimidia.
 *
 * @author Manoela Resende
 * @author Eduarda Sifuentes
 */

public class Musica extends Multimidia {
    //ATRIBUTOS
    private String[] compositores;
    private int num;
    private String[] interpretes;

    /**
     * Construtor da classe Musica.
     *
     * @param titulo Título da música.
     * @param genero Gênero da música.
    */
    public Musica(String titulo, String genero) {
        super(titulo, genero);
    }

    //GETTERS E SETTERS
    public String[] getCompositores() {
        return compositores;
    }

    public void setCompositores(String[] compositores) {
        this.compositores = compositores;
        this.num= compositores.length;
    }

    public String[] getInterpretes() {
        return interpretes;
    }

    public void setInterpretes(String[] interpretes) {
        this.interpretes = interpretes;
        this.num= interpretes.length;
    }

    /**
     * Método toString para representação em String da classe Musica
     * 
     * @return Uma representação em String da classe Musica, juntando
     * com as informações da classe midia
     */
    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Compositores: " + Arrays.toString(getCompositores()) + "\n" +
                "Intérpretes: " + Arrays.toString(getInterpretes()) + "\n";
    }
}

