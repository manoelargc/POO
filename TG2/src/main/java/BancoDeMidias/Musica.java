package BancoDeMidias;

public class Musica extends Multimidia {
    //atributos
    private String compositores;
    private String interpretes;

    public Musica(String titulo, String genero) {
        super(titulo, genero);
    }

    //metodos especiais
    //get e set

    public String getCompositores() {
        return compositores;
    }

    public void setCompositores(String compositores) {
        this.compositores = compositores;
    }

    public String getInterpretes() {
        return interpretes;
    }

    public void setInterpretes(String interpretes) {
        this.interpretes = interpretes;
    }

    //tostring
    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Compositores: " + getCompositores() + "\n" +
                "Intérpretes: " + getInterpretes() + "\n";
    }
}

