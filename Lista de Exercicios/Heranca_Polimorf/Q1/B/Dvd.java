package Q1.B;

import Q1.A.Produtos;

public class Dvd extends Produtos {

    //atributos extras
    private String autor;
    private String estilo;


    //get e set

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    //sobreescrever pra gravar especificos
    @Override
    public String toString() {
        return super.toString() + ", Autor: " + this.autor + ", Estilo: " + this.estilo;
    }
}
