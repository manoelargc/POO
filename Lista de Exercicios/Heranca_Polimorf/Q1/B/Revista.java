package Q1.B;

import Q1.A.Produtos;

public class Revista extends Produtos {

    //atributos extras
    private String editora;

    //metodos especiais

    //get e set

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    //sobreescrever pra printar com as especificas
    @Override
    public String toString() {
        return super.toString() + ", Editora: " + this.editora;
    }
}
