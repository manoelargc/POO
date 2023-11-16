package BancoDeMidias;

import java.util.Arrays;

public class Musica extends Multimidia {
    //atributos
    private String[] compositores;
    private int num;
    private String[] interpretes;

    public Musica(String titulo, String genero) {
        super(titulo, genero);
    }

    //metodos especiais
    //get e set

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

    //tostring
    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Compositores: " + Arrays.toString(getCompositores()) + "\n" +
                "Intérpretes: " + Arrays.toString(getInterpretes()) + "\n";
    }

    @Override
    public String getTipo() {
        return "Musica";
    }
}

