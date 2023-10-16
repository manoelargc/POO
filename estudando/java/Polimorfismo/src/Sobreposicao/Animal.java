package Sobreposicao;

public abstract class Animal {
    //atributos
    private float peso;
    private int idade;
    private int membros;

    //metodos abs
    public abstract void locomover();
    public abstract void alimentar();
    public abstract void emitirSom();

    //metodos especiais

    //get e set

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getMembros() {
        return membros;
    }

    public void setMembros(int membros) {
        this.membros = membros;
    }
}
