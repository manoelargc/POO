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

    private void gerenciarEstoque() {
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
                        break;
                    case 2://remover produto
                        break;
                    case 3://mostrar produto
                        break;
                    case 4://atualizar quantidade total
                        break;
                    case 5://atualizar preço
                        break;
                    case 6://adicionar quantidade de produto em estoque
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

    private void gerenciarNotasFiscais() {
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
                    case 1://adicionar nf
                        break;
                    case 2://excluir nf
                        break;
                    case 3://mostrar nf
                        break;
                    case 4:// preço total de uma nf
                        break;
                    case 5://adicionar item na nf
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
}