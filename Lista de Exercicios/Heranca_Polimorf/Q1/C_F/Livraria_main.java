
package Q1.C_F;

import Q1.A.Produtos;
import Q1.B.Livro;
import Q1.B.Revista;
import Q1.B.Dvd;
import Q1.E.ListaProdutos;

import java.io.FileWriter;
import java.io.IOException;


public class Livraria_main {

    public static void main(String[] args) {

        //LETRA C

        /*instancia das duas revistas r1 e r2
        Revista r1 = new Revista();
        Revista r2 = new Revista();

        //mudar o atributo de valor do r1 p/ dez reais
        r1.setValor(10.0f);

        //muda nome de r2 p/ info exame
        r2.setNome("Info Exame");

        //muda a editora de r2 pra globo
        r2.setEditora("Globo");

        //testando para responder a letra C da Q1
        System.out.println(r1.getValor());
        System.out.println(r2.getNome());
        System.out.println(r2.getEditora());*/

        //----------------------------------------------------

        // Crie uma instância da classe ListaProdutos
        ListaProdutos lista = new ListaProdutos();

        // Crie alguns produtos
        Livro livro = new Livro();
        livro.setCodigo(1);
        livro.setNome("Harry Potter e a Câmara Secreta");
        livro.setValor(45.90f);
        livro.setAutor("J. K. Rowling");
        livro.setEditora("Rocco");

        Revista revista = new Revista();
        revista.setCodigo(2);
        revista.setNome("Info Exame");
        revista.setValor(10.0f);
        revista.setEditora("Globo");

        Dvd dvd = new Dvd();
        dvd.setCodigo(3);
        dvd.setNome("Gente Grande");
        dvd.setValor(59.90f);
        dvd.setAutor("Dennis Dugan");
        dvd.setEstilo("Comédia");

        // Adicione os produtos à lista
        lista.incluir(livro);
        lista.incluir(revista);
        lista.incluir(dvd);

        // Crie um FileWriter para escrever em um arquivo
        try (FileWriter writer = new FileWriter("produtos.txt")) {
            // Liste todos os produtos e escreva-os no arquivo
            for (int i = 0; i < lista.getTamanho(); i++) {
                Produtos produto = lista.getProduto(i);
                String produtoDetalhes =
                        "Código: " + produto.getCodigo() +
                        ", Nome: " + produto.getNome() +
                        ", Valor: " + produto.getValor();

                //se for livro        
                if (produto instanceof Livro) {
                    livro = (Livro) produto;
                    produtoDetalhes +=
                            ", Autor: " + livro.getAutor() +
                            ", Editora: " + livro.getEditora();

                //se for revista
                } else if (produto instanceof Revista) {
                    revista = (Revista) produto;
                    produtoDetalhes += 
                            ", Editora: " + revista.getEditora();


                //se for dvd
                } else if (produto instanceof Dvd) {
                    dvd = (Dvd) produto;
                    produtoDetalhes += 
                            ", Autor: " + dvd.getAutor() +
                            ", Estilo: " + dvd.getEstilo();
                }
                writer.write(produtoDetalhes + "\n");
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao escrever no arquivo.");
            e.printStackTrace();
        }
    }
}


