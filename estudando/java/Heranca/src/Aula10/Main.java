package Aula10;

public class Main {
    public static void main(String[] args) {

        //Pessoa p1 = new Pessoa();
        Aluno p2 = new Aluno();
        Professor p3 = new Professor();
        Bolsista p4 = new Bolsista();

        p4.setNome("Manu");
        p4.pagarMensalidade();


        System.out.println(p4.toString());
    }
}
