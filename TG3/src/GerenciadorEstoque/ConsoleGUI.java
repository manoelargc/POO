package GerenciadorEstoque;

import java.util.Scanner;

public class ConsoleGUI {
    private Estoque estoque;
    private GerenciadorNF gerenciadorNF;
    private Scanner scanner;

    public ConsoleGUI() {
        this.estoque = new Estoque();
        this.gerenciadorNF = new GerenciadorNF();
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        while (true) {
            try {
                System.out.println("\n========= Gerenciador =========");
                System.out.println("1. Estoque");
                System.out.println("2. Notas Fiscais");
                System.out.println("0. Sair");
                System.out.print("\nDigite a opção: ");

                int opcao = scanner.nextInt();
                scanner.nextLine();  // Consume newline left-over

                switch (opcao) {
                    case 1:
                        gerenciarEstoque();
                        break;
                    case 2:
                        gerenciarNotasFiscais();
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        return;
                    default:
                        System.out.println("Opção inválida. Por favor, tente novamente.");
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro: " + e.getMessage());
            }
        }
    }

    public void gerenciarEstoque() {
        while (true) {
            try {
                System.out.println("\nGerenciador de Estoque:");
                System.out.println("1. Adicionar produto");
                System.out.println("2. Remover produto");
                System.out.println("3. Mostrar produto");
                System.out.println("4. Atualizar quantidade total em estoque de um produto");
                System.out.println("5. Atualizar preço do produto");
                System.out.println("6. Adicionar quantidade de produto em estoque");
                System.out.println("7. Subtrair quantidade produto em estoque");
                System.out.println("0. Voltar ao menu principal");
                System.out.print("\nDigite a opção: ");

                int opcao = scanner.nextInt();
                scanner.nextLine();  // Consume newline left-over

                switch (opcao) {
                    case 1://cadastrar produto
                        System.out.println("Digite o nome do produto:");
                        String nome = scanner.nextLine();
                        System.out.println("Digite a descrição do produto:");
                        String descricao = scanner.nextLine();
                        System.out.println("Digite o preço do produto:");
                        double preco = scanner.nextDouble();
                        scanner.nextLine();  // Consume newline left-over

                        System.out.println("Produto é por Kg ou UN?");
                        String tipo = scanner.nextLine();

                        if(tipo.equalsIgnoreCase("kg")){
                            System.out.println("Digite a quantidade do produto:");
                            double quantidade = scanner.nextInt();
                            scanner.nextLine();  // Consume newline left-over
                            ProdutoKG kg = new ProdutoKG(nome,descricao,preco,quantidade);
                            estoque.addProduto(kg);
                        } else if (tipo.equalsIgnoreCase("un")){
                            System.out.println("Digite a quantidade do produto:");
                            int quantidade = scanner.nextInt();
                            scanner.nextLine();  // Consume newline left-over
                            ProdutoUN un = new ProdutoUN(nome,descricao,preco,quantidade);
                            estoque.addProduto(un);
                        }
                            System.out.println(estoque.toString());
                        break;
                    case 2://remover produto
                        break;
                    case 3://mostrar produto
                        break;
                    case 4://atualizar quantidade total
                        break;
                    case 5://atualizar preço
                        break;
                    case 6://add quantidade de produto em estoque
                        break;
                    case 7:
                        //subtrair quantidade de produto em estoque
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Opção inválida. Por favor, tente novamente.");
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro: " + e.getMessage());
            }
        }
    }

    public void gerenciarNotasFiscais() {
        while (true) {
            try {
                System.out.println("\nGerenciador de Notas Fiscais:");
                System.out.println("1. Adicionar NFe");
                System.out.println("2. Excluir NFe");
                System.out.println("3. Mostrar NFe");
                System.out.println("4. Retornar preço total de uma NFe");
                System.out.println("5. Adicionar item na NFe");
                System.out.println("6. Remover item da NFe");
                System.out.println("0. Voltar ao menu principal");
                System.out.print("\nDigite a opção: ");

                int opcao = scanner.nextInt();
                scanner.nextLine();  // Consume newline left-over

                switch (opcao) {
                    case 1://add nf
                        break;
                    case 2://excluir nf
                        break;
                    case 3://mostrar nf
                        break;
                    case 4:// preço total de uma nf
                        break;
                    case 5://add item na nf
                        break;
                    case 6://remover item da nf
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Opção inválida. Por favor, tente novamente.");
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro: " + e.getMessage());
            }
        }
    }

    /*public void addProduto() {
        System.out.println("Digite o nome do produto:");
        String nome = scanner.nextLine();
        System.out.println("Digite a descrição do produto:");
        String descricao = scanner.nextLine();
        System.out.println("Digite o preço do produto:");
        double preco = scanner.nextDouble();
        scanner.nextLine();  // Consume newline left-over
        System.out.println("Digite a quantidade do produto:");
        int quantidade = scanner.nextInt();
        scanner.nextLine();  // Consume newline left-over
        Produto produto = new Produto(nome, descricao, preco);
        estoque.addProduto(produto);
        System.out.println("Produto adicionado com sucesso.");
    }

    public void removerProduto() {
        System.out.println("Digite o código do produto que deseja remover:");
        int codigo = scanner.nextInt();
        scanner.nextLine();  // Consume newline left-over
        estoque.removeProduto(codigo);
        System.out.println("Produto removido com sucesso.");
    }

    public void mostrarProduto() {
        System.out.println("Digite o código do produto que deseja visualizar:");
        int codigoProduto = scanner.nextInt();
        scanner.nextLine();  // Consume newline left-over
        Produto produtoEncontrado = estoque.getProduto(codigoProduto);
        System.out.println(produtoEncontrado);
    }

    public void atualizarQuantidadeTotal() {
        System.out.println("Digite o código do produto que deseja atualizar:");
        int codigoAtualizar = scanner.nextInt();
        scanner.nextLine();  // Consume newline left-over
        System.out.println("Digite a nova quantidade:");
        int novaQuantidade = scanner.nextInt();
        scanner.nextLine();  // Consume newline left-over
        estoque.updateProduto(codigoAtualizar, novaQuantidade);
        System.out.println("Quantidade atualizada com sucesso.");
    }

    public void atualizarPreco() {
        System.out.println("Digite o código do produto que deseja atualizar o preço:");
        int codigoPreco = scanner.nextInt();
        scanner.nextLine();  // Consume newline left-over
        System.out.println("Digite o novo preço:");
        double novoPreco = scanner.nextDouble();
        scanner.nextLine();  // Consume newline left-over
        estoque.updatePreco(codigoPreco, novoPreco);
        System.out.println("Preço atualizado com sucesso.");
    }

    public void addQuantidade() {
        System.out.println("Digite o código do produto que deseja add quantidade:");
        int codigoAdicionar = scanner.nextInt();
        scanner.nextLine();  // Consume newline left-over
        System.out.println("Digite a quantidade a ser adicionada:");
        int quantidadeAdicionar = scanner.nextInt();
        scanner.nextLine();  // Consume newline left-over
        estoque.addQuantidade(codigoAdicionar, quantidadeAdicionar);
        System.out.println("Quantidade adicionada com sucesso.");
    }

    public void subtrairQuantidade() {
        System.out.println("Digite o código do produto que deseja subtrair quantidade:");
        int codigoSubtrair = scanner.nextInt();
        scanner.nextLine();  // Consume newline left-over
        System.out.println("Digite a quantidade a ser subtraída:");
        int quantidadeSubtrair = scanner.nextInt();
        scanner.nextLine();  // Consume newline left-over
        estoque.subQuantidade(codigoSubtrair, quantidadeSubtrair);
        System.out.println("Quantidade subtraída com sucesso.");
    }
*/
}