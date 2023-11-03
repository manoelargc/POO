package BancoDeMidias;

public class Musica extends Multimidia {
    //atributos
    private String autores;
    private String interpretes;

    //metodos especiais
    //get e set

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public String getInterpretes() {
        return interpretes;
    }

    public void setInterpretes(String interpretes) {
        this.interpretes = interpretes;
    }
}
