package Aula10;

public class Aluno extends Pessoa{
    private int matricula;
    private String curso;

    //metodos publicos
    public void pagarMensalidade(){
        System.out.println("Pagando mensalidade aluno " + this.getNome());
    }

    //metodos especiais

    //get & set

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
