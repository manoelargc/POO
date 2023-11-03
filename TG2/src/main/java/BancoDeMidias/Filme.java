package BancoDeMidias;

public class Filme extends Multimidia {
    //atributos
    private String diretor;
    private String atores;

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
}
