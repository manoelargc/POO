package Aula10;

public class Professor {
    private String especialidade;
    private int salario;

    //metodos publicos
    public void receberAumento(int aumento){
        this.setSalario(getSalario()+aumento);
    }

    //metodos especiais


    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }
}
