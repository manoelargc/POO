package Q2.A;

import Q2.Aposentadoria;
import Q2.Pessoa;

public class Tecnico extends Pessoa implements Aposentadoria {
    //atributos
    private int siape;


    //construtor
    public Tecnico(String nome, int siape){
        this.nome=nome;
        this.siape=siape;
    }

    //get e set

    public int getSiape() {
        return siape;
    }

    public void setSiape(int siape) {
        this.siape = siape;
    }

    @Override
    public int calculaTempoMinimo() {
        System.out.println(this.getNome() + " precisa de uma contribuição mínima de 30 anos" );
        return 30;
    }

}
