package BancoDeMidias;

public class Filme extends Multimidia {
    //atributos
    private String diretor;
    private String atores;

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

    public String getAtores() {
        return atores;
    }

    public void setAtores(String atores) {
        this.atores = atores;
    }

    //tostring
    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Diretor: " + getDiretor() + "\n" +
                "Atores Principais: " + getAtores();
    }

}
