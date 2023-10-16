package Aula7;

public class Aula7 {

    public static void main(String[] args) {
    Lutador l[] = new Lutador[2];

    l[0] = new Lutador("Spider", "BR", 28, 1.80f, 78.0f, 6, 1, 5);

    l[1] = new Lutador("Wind", "BR", 25, 1.75f, 75.0f, 10, 0, 2);

    Luta uec01= new Luta();
    uec01.marcarLuta(l[0],l[1]);
    uec01.lutar();

    l[0].status();
    l[1].status();

    }
}
