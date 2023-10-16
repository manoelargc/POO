package Q1.B;

import Q1.A.Produtos;

public class Livro extends Produtos {
    //atributos extras

    private String autor;
    private String editora;


    //metodos especiais

    //construtor
/*    public Livro(String autor, String editora) {
        this.autor = autor;
        this.editora = editora;
    }*/


    //get e set


    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    //sobreescrever pra printar com as especificas
    @Override
    public String toString() {
        return super.toString() + ", Autor: " + this.autor + ", Editora: " + this.editora;
    }
}
