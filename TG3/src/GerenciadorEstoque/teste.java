package GerenciadorEstoque;
import java.text.SimpleDateFormat;


public class teste {
    public static void main(String[] args) {
        Produto p = new Produto("copo", "stanley", 100);
        p.setValidade("10-04-2024"); //tratamento de excecoes
        System.out.println(p);

        ProdutoUN un = new ProdutoUN("camisa", "teste", 60.00, 1);
        System.out.println(un);

        ProdutoKG kg = new ProdutoKG("cafe", "forte", 15.50, 0.8);
        System.out.println(kg);



    }
}
