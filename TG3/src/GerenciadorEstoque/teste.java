package GerenciadorEstoque;

import java.text.SimpleDateFormat;


public class teste {
    public static void main(String[] args) {
/*        Produto p = new Produto("copo", "stanley", 100);
        p.setValidade("10-04-2024"); //tratamento de excecoes
        System.out.println(p);*/

  /*     ProdutoUN un = new ProdutoUN("camisa", "teste", 60.00, 1);
        System.out.println(un);*/

        ProdutoKG kg = new ProdutoKG("cafe", "forte", 15.50, 1);
        //System.out.println(kg);
        ProdutoKG kg2 = new ProdutoKG("queijo", "mussarela", 32.0, 1);
        //System.out.println(kg);

/*        // Cria um estoque
        Estoque estoque = new Estoque();

        // Adiciona os produtos ao estoque
        estoque.addProduto(un);
        estoque.addProduto(kg);
        estoque.addProduto(kg2);

        // Imprime os produtos
        System.out.println(estoque.getProduto(un.getCodigo()));
        System.out.println(estoque.getProduto(kg.getCodigo()));

        // Atualiza a quantidade de um produto
        estoque.addQuantidade(un.getCodigo(), 5);
        System.out.println("Quantidade do Produto UN após adicionar 2: " + ((ProdutoUN) estoque.getProduto(un.getCodigo())).getQuantidade());

        // Remove um produto
        estoque.removeProduto(kg.getCodigo());
        System.out.println("Produto KG após remoção: " + estoque.getProduto(kg.getCodigo()));
   */
        // Criação de alguns produtos
        Produto p1 = new ProdutoKG("Carne Moida", "Carne Moida 1", 20.0, 1);
        Produto p2 = new ProdutoUN("Leite", "Caixa com 1L", 3.50, 1);

// Criação da nota fiscal
        NotaFiscal nf = new NotaFiscal();

// Adicionando itens à nota fiscal
        nf.adicionarItem(p1, 0.7); // 700g carne
        nf.adicionarItem(p2, 3); // 3 caixas

        NotaFiscal nf2 = new NotaFiscal();
        nf2.adicionarItem(kg,1.2);
        nf2.adicionarItem(kg2,0.3);

        GerenciadorNF gerenciadorNF = new GerenciadorNF();
        gerenciadorNF.addNotaFiscal(nf);
        gerenciadorNF.addNotaFiscal(nf2);
        System.out.println(gerenciadorNF);

        System.out.println("******************************");
        gerenciadorNF.removeNotaFiscal(nf.getCodigo());
        System.out.println(gerenciadorNF);
// Imprimindo a nota fiscal
        System.out.println(nf);


    }
}
