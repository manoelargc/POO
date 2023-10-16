package Q2.C;

import Q2.A.Tecnico;
import Q2.B.Professor;

public class Main {
    public static void main(String[] args) {

        Tecnico p1 = new Tecnico("Manoela", 1111);
        Professor p2 = new Professor("Aline", 2323, "CC");

        p1.calculaTempoMinimo();
        p2.calculaTempoMinimo();


    }
}
