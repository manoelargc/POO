package Sobreposicao;

public class Main {

    public static void main(String[] args) {
        Mamifero m = new Mamifero();
        Reptil r = new Reptil();
        Peixe p = new Peixe();
        Ave a = new Ave();
        Goldfish g = new Goldfish();
        Tartaruga t = new Tartaruga();

        m.locomover();
        m.alimentar();
        m.emitirSom();

        r.alimentar();
        t.locomover();

        g.soltarBolha();

        a.fazerNinho();
    }
}
