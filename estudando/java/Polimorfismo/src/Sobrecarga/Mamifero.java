package Sobrecarga;
public class Mamifero extends Animal {

    //atributos
    private String corPelo;

    @Override
    public void emitirSom() {
        System.out.println("Som de mamifero");
    }


    //metodos especiais

    //get e set

    public String getCorPelo() {
        return corPelo;
    }

    public void setCorPelo(String corPelo) {
        this.corPelo = corPelo;
    }
}
