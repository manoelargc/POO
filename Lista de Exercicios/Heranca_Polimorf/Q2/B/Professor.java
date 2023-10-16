package Q2.B;

import Q2.Aposentadoria;
import Q2.Pessoa;

public class Professor extends Pessoa implements Aposentadoria {
    //atributos
    private int siape;
    private String curso;

    //metodos especiais

    //construtor
    public Professor(String nome, int siape, String curso){
        this.siape=siape;
        this.curso=curso;
        this.nome=nome;
    }

    //get e set

    public int getSiape() {
        return siape;
    }

    public void setSiape(int siape) {
        this.siape = siape;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public int calculaTempoMinimo() {
        System.out.println(this.getNome() + " precisa de uma contribuição mínima de 20 anos" );
        return 20;
    }
}
