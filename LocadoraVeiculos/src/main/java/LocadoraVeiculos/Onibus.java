package LocadoraVeiculos;

public class Onibus extends Veiculo{


    //atributos
    private String categoria;


    //construtor

    public Onibus(String categoria) {
        this.categoria = categoria;
    }


    //get e set

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
