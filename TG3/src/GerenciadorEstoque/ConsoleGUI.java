package GerenciadorEstoque;

import java.util.Scanner;

public class ConsoleGUI {
    private Arquivo arquivo;
    private Scanner scanner;

    public ConsoleGUI() {
        this.arquivo = new Arquivo(); // Carrega os dados do arquivo
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
                        arquivo.salvarEstoque(arquivo.getEstoque());
                        arquivo.salvarGerenciadorNF(arquivo.getGerenciadorNF());
                        break;
                    default:
                        System.out.println("Opção inválida. Por favor, tente novamente.");
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro: " + e.getMessage());
                break;
            }
        }
    }


    public void cadastrarProduto() {
        System.out.println("Digite o nome do produto:");
        String nome = scanner.nextLine();
        System.out.println("Digite a descrição do produto:");
        String descricao = scanner.nextLine();
        System.out.println("Digite o preço do produto:");
        double preco = scanner.nextDouble();
        System.out.println(preco);
        scanner.nextLine();  // Consume newline left-over

        System.out.println("Produto é por Kg ou UN?");
        String tipo = scanner.nextLine();

        if (tipo.equalsIgnoreCase("kg")) {
            System.out.println("Digite a quantidade do produto:");
            double quantidade = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over
            ProdutoKG kg = new ProdutoKG(nome, descricao, preco, quantidade);
            arquivo.getEstoque().addProduto(kg);
        } else if (tipo.equalsIgnoreCase("un")) {
            System.out.println("Digite a quantidade do produto:");
            int quantidade = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over
            ProdutoUN un = new ProdutoUN(nome, descricao, preco, quantidade);
            arquivo.getEstoque().addProduto(un);
        }
        System.out.println(arquivo.getEstoque().getProdutos());
    }

    public void removerProduto() {
        System.out.println("Digite o código do produto que deseja remover:");
        int codigo = scanner.nextInt();
        scanner.nextLine();  // Consume newline left-over
        arquivo.getEstoque().removeProduto(codigo);
        System.out.println("Produto removido com sucesso.");
    }

    public void mostrarProduto() {
        System.out.println("Você deseja visualizar todos os produtos ou apenas um?");
        System.out.println("1. Visualizar todos os produtos");
        System.out.println("2. Visualizar um produto");
        System.out.print("\nDigite a opção: ");

        int op = scanner.nextInt();
        scanner.nextLine();  // Consume newline left-over

        if (op == 1) {
            // Visualizar todos os produtos
            for (Produto produto : arquivo.getEstoque().getProdutos()) {
                System.out.println(produto);
            }
        } else if (op == 2) {
            // Visualizar um produto
            System.out.println("Digite o código do produto que deseja visualizar:");
            int codigoProduto = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over
            Produto produtoEncontrado = arquivo.getEstoque().getProduto(codigoProduto);
            System.out.println(produtoEncontrado);
        } else {
            System.out.println("Opção inválida. Por favor, tente novamente.");
        }

    }

    public void atualizarPreco() {
        System.out.println("Digite o código do produto que deseja atualizar o preço:");
        int codigoPreco = scanner.nextInt();
        scanner.nextLine();  // Consume newline left-over
        System.out.println("Digite o novo preço:");
        double novoPreco = scanner.nextDouble();
        scanner.nextLine();  // Consume newline left-over
        arquivo.getEstoque().updatePreco(codigoPreco, novoPreco);
        System.out.println("Preço atualizado com sucesso.");

    }

    public void addEstoqueProd() {
        System.out.println("Digite o código do produto que deseja add quantidade:");
        int codigoAdicionar = scanner.nextInt();
        scanner.nextLine();  // Consume newline left-over
        System.out.println("Digite a quantidade a ser adicionada:");
        double quantidadeAdicionar = scanner.nextDouble();
        scanner.nextLine();  // Consume newline left-over
        arquivo.getEstoque().addQuantidade(codigoAdicionar, quantidadeAdicionar);
        System.out.println("Quantidade adicionada com sucesso.");
    }

    public void subEstoqueProd() {
        System.out.println("Digite o código do produto que deseja subtrair quantidade:");
        int codigoSubtrair = scanner.nextInt();
        scanner.nextLine();  // Consume newline left-over
        System.out.println("Digite a quantidade a ser subtraída:");
        double quantidadeSubtrair = scanner.nextDouble();
        scanner.nextLine();  // Consume newline left-over
        arquivo.getEstoque().subQuantidade(codigoSubtrair, quantidadeSubtrair);
        System.out.println("Quantidade subtraída com sucesso.");
    }

    public void gerenciarEstoque() {
        int opcao = 0;
        do {
            try {
                System.out.println("\nGerenciador de Estoque:");
                System.out.println("1. Adicionar produto");
                System.out.println("2. Remover produto");
                System.out.println("3. Mostrar produto");
                System.out.println("4. Atualizar preço do produto");
                System.out.println("5. Adicionar quantidade de produto em estoque");
                System.out.println("6. Subtrair quantidade produto em estoque");
                System.out.println("0. Voltar ao menu principal");
                System.out.print("\nDigite a opção: ");

                opcao = scanner.nextInt();
                scanner.nextLine();  // Consume newline left-over

                switch (opcao) {
                    case 1://cadastrar produto
                        cadastrarProduto();
                        break;

                    case 2://remover produto
                        removerProduto();
                        break;

                    case 3://mostrar produto
                        mostrarProduto();
                        break;
                    case 4://atualizar preço
                        atualizarPreco();
                        break;
                    case 5://add quantidade de produto em estoque
                        addEstoqueProd();
                        break;
                    case 6:
                        //subtrair quantidade de produto em estoque
                        subEstoqueProd();
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Opção inválida. Por favor, tente novamente.");
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro: " + e.getMessage());
                break;
            }
        } while (opcao != 0);
    }

    public void gerenciarNotasFiscais() {
        while (true) {
            try {
                System.out.println("\nGerenciador de Notas Fiscais:");
                System.out.println("1. Criar NFe");
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
                        NotaFiscal nf = new NotaFiscal(); // Crie um novo objeto NotaFiscal
                        // Defina as propriedades da NotaFiscal
                        arquivo.getGerenciadorNF().addNotaFiscal(nf); // Adicione a NotaFiscal
                        System.out.println(nf);
                        System.out.println("Nota Fiscal criada com sucesso.");
                        break;
                    case 2://excluir nf
                        System.out.print("Digite o código da NFe que você deseja remover: ");
                        int codigoRemove = scanner.nextInt();
                        scanner.nextLine();  // Consume newline left-over
                        arquivo.getGerenciadorNF().removeNotaFiscal(codigoRemove); // Remova a NotaFiscal
                        System.out.println("Nota Fiscal removida com sucesso.");
                        break;
                    case 3://mostrar nf
                        System.out.print("Digite o código da NFe que você deseja mostrar: ");
                        int codigoMostra = scanner.nextInt();
                        scanner.nextLine();  // Consume newline left-over
                        NotaFiscal nfEncontrada = arquivo.getGerenciadorNF().getNotaFiscal(codigoMostra); // Obtenha a NotaFiscal
                        System.out.println(nfEncontrada); // Imprima a NotaFiscal
                        break;
                    case 4:// preço total de uma nf
                        System.out.println("1. Saber o total vendido a partir da soma do total de todas as notas fiscais");
                        System.out.println("2. Saber o total vendido em um determinado dia");
                        System.out.println("3. Saber o total vendido em um determinado período");
                        System.out.print("\nDigite a opção: ");

                        int opTotal = scanner.nextInt();
                        scanner.nextLine();  // Consume newline left-over

                        switch (opTotal) {
                            case 1:
                                double totalVendido = arquivo.getGerenciadorNF().getTotalVendido();
                                System.out.println("O total vendido a partir da soma do total de todas as notas fiscais é: " + totalVendido);
                                break;
                            case 2:
                                System.out.println("Digite a data (formato dd/MM/yyyy):");
                                String data = scanner.nextLine();
                                double totalVendidoDia = arquivo.getGerenciadorNF().getTotalVendido(data);
                                System.out.println("O total vendido no dia " + data + " é: " + totalVendidoDia);
                                break;
                            case 3:
                                System.out.println("Digite a data de início (formato dd/MM/yyyy):");
                                String dataInicio = scanner.nextLine();
                                System.out.println("Digite a data de fim (formato dd/MM/yyyy):");
                                String dataFim = scanner.nextLine();
                                /*double totalVendidoPeriodo = arquivo.getGerenciadorNF().getTotalVendido(dataInicio, dataFim);
                                System.out.println("O total vendido no período de " + dataInicio + " a " + dataFim + " é: " + totalVendidoPeriodo);*/
                                break;
                            default:
                                System.out.println("Opção inválida. Por favor, tente novamente.");
                        }

                        break;
                    case 5://add item na nf
                        System.out.println("Digite o código da NFe que você deseja adicionar um item:");
                        int codigoNFe = scanner.nextInt();
                        scanner.nextLine();  // Consume newline left-over

                        System.out.println("Digite o código do produto que você deseja adicionar:");
                        int codigoProduto = scanner.nextInt();
                        scanner.nextLine();  // Consume newline left-over

                        System.out.println("Digite a quantidade do produto:");
                        double quantidade = scanner.nextDouble();
                        scanner.nextLine();  // Consume newline left-over

                        Produto produto = arquivo.getEstoque().getProduto(codigoProduto);
                        if (produto != null) {
                            NotaFiscal nfItemAdd = arquivo.getGerenciadorNF().getNotaFiscal(codigoNFe);
                            if (nfItemAdd != null) {
                                nfItemAdd.adicionarItem(produto, quantidade);
                                System.out.println("Item adicionado com sucesso.");
                            } else {
                                System.out.println("NFe não encontrada.");
                            }
                        } else {
                            System.out.println("Produto não encontrado.");
                        }
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
