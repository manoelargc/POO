package LocadoraVeiculos;

public class Main {
    public static void main(String[] args) {

        //questao 2

        //a
        Carro c1 = new Carro(2, 20);
        Carro c2 = new Carro(4, 15);

        //b
        c1.setnPortas(4);

        //c
        c2.getMediaKmL(15.5f);

        //d
        System.out.println(c1.getnPortas() + " portas");



    }
}
