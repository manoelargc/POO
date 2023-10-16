package Sobrecarga;

public class Main {

    public static void main(String[] args) {

        Cachorro c = new Cachorro();

        c.reagir("Oi");
        c.reagir(true);
        c.reagir(20,10);
    }
}
