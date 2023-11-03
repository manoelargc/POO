package BancoDeMidias;

public class Nodo {
    // Atributos
    private Midia midia;
    private Nodo esquerda;
    private Nodo direita;

    // Construtor
    public Nodo(Midia midia) {
        this.midia = midia;
    }

    // Métodos
    public Midia getMidia() {
        return midia;
    }

    public Nodo getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(Nodo esquerda) {
        this.esquerda = esquerda;
    }

    public Nodo getDireita() {
        return direita;
    }

    public void setDireita(Nodo direita) {
        this.direita = direita;
    }
}
