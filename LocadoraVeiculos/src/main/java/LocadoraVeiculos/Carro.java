package LocadoraVeiculos;

public class Carro extends Veiculo{

    //atributos
    private int nPortas;
    private float mediaKmL;

    //metodos especiais

    //construtor

    public Carro(int nPortas, float mediaKmL) {
        this.nPortas = nPortas;
        this.mediaKmL = mediaKmL;
    }

    //get e set


    public int getnPortas() {
        return nPortas;
    }

    public void setnPortas(int nPortas) {
        this.nPortas = nPortas;
    }

    public float getMediaKmL(float v) {
        return mediaKmL;
    }

    public void setMediaKmL(float mediaKmL) {
        this.mediaKmL = mediaKmL;
    }
}
