package Aula10;

public abstract class Pessoa {
    //atributos

    private String nome;
    private int idade;
    private String sexo;

    //metodos publicos

    public final void fazerAniv(){
        this.setIdade(getIdade()+1);
    }

    //metodos especiais

    //get & set

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", sexo='" + sexo + '\'' +
                '}';
    }
}
