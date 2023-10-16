package Sobreposicao;

public class Reptil extends Animal{
    private String corEscama;

    //met abs


    @Override
    public void locomover() {
        System.out.println("Rastejando");
    }

    @Override
    public void alimentar() {
        System.out.println("Comendo plantas");
    }

    @Override
    public void emitirSom() {
        System.out.println("Som de reptil");
    }



    //metodos especiais

    //get e set

    public String getCorEscama() {
        return corEscama;
    }

    public void setCorEscama(String corEscama) {
        this.corEscama = corEscama;
    }
}
