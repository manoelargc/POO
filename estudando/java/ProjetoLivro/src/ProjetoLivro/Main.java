package ProjetoLivro;

public class Main {
    public static void main(String[] args) {

        Pessoa p[]= new Pessoa[1];
        Livro l[]= new Livro[1];

        p[0] = new Pessoa("Manu", 20, "F");
        l[0] = new Livro("PJ", "Rick R", 250, p[0]);

        l[0].abrir();
        l[0].folhear(300);
        l[0].fechar();
        l[0].detalhes();
    }
}
