package Sobreposicao;

public class Peixe extends Animal{
    private String corEscama;

    public void soltarBolha(){
        System.out.println("Soltando bolha");
    }

    //metodos abs
    @Override
    public void locomover() {
        System.out.println("Nadando");
    }

    @Override
    public void alimentar() {
        System.out.println("Comendo Substancias");
    }

    @Override
    public void emitirSom() {
        System.out.println("Peixe não emite som");
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
