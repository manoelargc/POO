package GerenciadorEstoque;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ConsoleGUI {
    private Arquivo arquivo;
    private Scanner scanner;

    public ConsoleGUI() {
        this.arquivo = new Arquivo(); // Carrega os dados do arquivo
        this.scanner = new Scanner(System.in);
    }

    public boolean iniciar() {
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
                        return false;
                    default:
                        System.out.println("Opção inválida. Por favor, tente novamente.");
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro: " + e.getMessage());
                break;
            }
        }
        return false;
    }


    public void cadastrarProduto() {
        try {
            System.out.println("Digite o nome do produto:");
            String nome = scanner.nextLine();
            System.out.println("Digite a descrição do produto:");
            String descricao = scanner.nextLine();
            System.out.println("Digite o preço do produto:");
            double preco = scanner.nextDouble();
            System.out.println(preco);
            scanner.nextLine();  // Consume newline left-over
            System.out.println("Digite a validade do produto:");
            String validade = scanner.nextLine();

            System.out.println("Produto é por Kg ou UN?");
            System.out.println("1. Kg");
            System.out.println("2. UN");
            int tipo = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over

            switch (tipo) {
                case 1:
                    System.out.println("Digite a quantidade do produto:");
                    double quantidadeKg = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline left-over
                    ProdutoKG kg = new ProdutoKG(nome, descricao, preco, validade, quantidadeKg);
                    arquivo.getEstoque().addProduto(kg);
                    break;
                case 2:
                    System.out.println("Digite a quantidade do produto:");
                    int quantidadeUn = scanner.nextInt();
                    scanner.nextLine();  // Consume newline left-over
                    ProdutoUN un = new ProdutoUN(nome, descricao, preco, validade, quantidadeUn);
                    arquivo.getEstoque().addProduto(un);
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }
            System.out.println(arquivo.getEstoque().getProdutos());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void removerProduto() {
        try {
            System.out.println("Digite o código do produto que deseja remover:");
            int codigo = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over
            arquivo.getEstoque().removeProduto(codigo);
            System.out.println("Produto removido com sucesso.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarProduto() {
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void addEstoqueProd() {
        try {
            System.out.println("Digite o código do produto que deseja add quantidade:");
            int codigoAdicionar = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over
            System.out.println("Digite a quantidade a ser adicionada:");
            double quantidadeAdicionar = scanner.nextDouble();
            scanner.nextLine();  // Consume newline left-over
            arquivo.getEstoque().addQuantidade(codigoAdicionar, quantidadeAdicionar);
            System.out.println("Quantidade adicionada com sucesso.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void subEstoqueProd() {
        try {
            System.out.println("Digite o código do produto que deseja subtrair quantidade:");
            int codigoSubtrair = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over
            System.out.println("Digite a quantidade a ser subtraída:");
            double quantidadeSubtrair = scanner.nextDouble();
            scanner.nextLine();  // Consume newline left-over
            arquivo.getEstoque().subQuantidade(codigoSubtrair, quantidadeSubtrair);
            System.out.println("Quantidade subtraída com sucesso.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editaProd() {
        System.out.println("Digite o código do produto que deseja atualizar:");
        int codigo = scanner.nextInt();
        scanner.nextLine();  // Consume newline left-over

        Produto produto = arquivo.getEstoque().getProduto(codigo);
        if (produto == null) {
            System.out.println("Produto não encontrado. Por favor, verifique o código e tente novamente.");
            return;
        }

        System.out.println("Qual campo você gostaria de atualizar?");
        System.out.println("1. Nome");
        System.out.println("2. Descrição");
        System.out.println("3. Preço");
        System.out.println("4. Validade");

        int opcao = scanner.nextInt();
        scanner.nextLine();  // Consume newline left-over

        switch (opcao) {
            case 1:
                System.out.println("Digite o novo nome:");
                String novoNome = scanner.nextLine();
                produto.setNome(novoNome);
                break;
            case 2:
                System.out.println("Digite a nova descrição:");
                String novaDescricao = scanner.nextLine();
                produto.setDescricao(novaDescricao);
                break;
            case 3:
                System.out.println("Digite o novo preço:");
                double novoPreco = scanner.nextDouble();
                scanner.nextLine();  // Consume newline left-over
                produto.setPreco(novoPreco);
                break;
            case 4:
                System.out.println("Digite a nova data de validade (formato dd/MM/yyyy):");
                String novaValidade = scanner.nextLine();
                produto.setValidade(novaValidade);
                break;
            default:
                System.out.println("Opção inválida. Por favor, tente novamente.");
        }

        if (arquivo.getEstoque().updateProduto(codigo, produto)) {
            System.out.println("Produto atualizado com sucesso.");
        } else {
            System.out.println("Não foi possível atualizar o produto. Por favor, tente novamente.");
        }
    }


    public void gerenciarEstoque() {
        int opcao = 0;
        do {
            try {
                System.out.println("\nGerenciador de Estoque:");
                System.out.println("1. Adicionar produto");
                System.out.println("2. Remover produto");
                System.out.println("3. Mostrar produto");
                System.out.println("4. Editar produto");
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
                    case 4://editar produto(nome, descricao, preço, validade)
                        editaProd();
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


    //=========================================================================

    public void criaNFe() {
        System.out.print("Digite a data da sua NFe: ");
        String dataNF = scanner.nextLine();  // Consume newline left-over
        NotaFiscal nf = new NotaFiscal(dataNF); // Crie um novo objeto NotaFiscal
        // Defina as propriedades da NotaFiscal
        arquivo.getGerenciadorNF().addNotaFiscal(nf); // Adicione a NotaFiscal
        //System.out.println(nf);
        System.out.println("Nota Fiscal criada com sucesso.");
    }

    public void excluiNFe() {
        System.out.print("Digite o código da NFe que você deseja remover: ");
        int codigoRemove = scanner.nextInt();
        scanner.nextLine();  // Consume newline left-over
        arquivo.getGerenciadorNF().removeNotaFiscal(codigoRemove); // Remova a NotaFiscal
        System.out.println("Nota Fiscal removida com sucesso.");
    }

    public void mostraNFe() {
        try {
            System.out.println("Você deseja visualizar todas as notas fiscais ou apenas uma?");
            System.out.println("1. Visualizar todas as notas fiscais");
            System.out.println("2. Visualizar uma nota fiscal");
            System.out.print("\nDigite a opção: ");

            int op = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over

            if (op == 1) {
                // Visualizar todas as notas fiscais
                for (NotaFiscal nf : arquivo.getGerenciadorNF().getNotasFiscais()) {
                    System.out.println(nf);
                }
            } else if (op == 2) {
                // Visualizar uma nota fiscal
                System.out.println("Digite o código da nota fiscal que deseja visualizar:");
                int codigoNF = scanner.nextInt();
                scanner.nextLine();  // Consume newline left-over
                NotaFiscal nfEncontrada = arquivo.getGerenciadorNF().getNotaFiscal(codigoNF);
                System.out.println(nfEncontrada);
            } else {
                System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void totalVendas() throws ParseException {
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
                datevenda();
                break;
            default:
                System.out.println("Opção inválida. Por favor, tente novamente.");
        }

    }

    public void datevenda(){
        System.out.println("Digite a data de início (formato dd/MM/yyyy):");
        String dataInicio = scanner.nextLine();
        System.out.println("Digite a data de fim (formato dd/MM/yyyy):");
        String dataFim = scanner.nextLine();
        double totalVendidoPeriodo = arquivo.getGerenciadorNF().getTotalVendido(dataInicio, dataFim);
        System.out.println("O total vendido no período de " + dataInicio + " a " + dataFim + " é: " + totalVendidoPeriodo);

    }
    public void addItemNFe() {
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
                arquivo.getEstoque().subQuantidade(codigoProduto,quantidade);
                System.out.println("Item adicionado com sucesso.");
            } else {
                System.out.println("NFe não encontrada.");
            }
        } else {
            System.out.println("Produto não encontrado.");
        }

    }

    public void removeItemNFe() {
            System.out.println("Digite o código da NFe de onde você deseja remover um item:");
            int codigoNFe = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over

            System.out.println("Digite o código do produto que você deseja remover:");
            int codigoProduto = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over

            Produto produto = arquivo.getEstoque().getProduto(codigoProduto);
            if (produto != null) {
                Item itemRemover = new Item(produto, 1); // A quantidade não importa ao remover o item
                boolean itemRemovido = arquivo.getGerenciadorNF().removeItem(codigoNFe, itemRemover);
                if (itemRemovido) {
                    System.out.println("Item removido com sucesso.");
                } else {
                    System.out.println("Não foi possível remover o item. Verifique o código da NFe e tente novamente.");
                }
            } else {
                System.out.println("Produto não encontrado.");
            }
        }

    public void editaNFe(){
        System.out.println("Digite o código da NFe que deseja editar:");
        int codigo = scanner.nextInt();
        scanner.nextLine();  // Consume newline left-over
        System.out.println("Digite a nova data da NFe:");
        String novaData = scanner.nextLine();
        NotaFiscal nova = new NotaFiscal(novaData);
        if (arquivo.getGerenciadorNF().updateNotaFiscal(codigo, nova)) {
            System.out.println("Nota Fiscal atualizada com sucesso.");
        } else {
            System.out.println("Não foi possível atualizar a Nota Fiscal. Verifique se o código está correto.");
        }
    }
    public void gerenciarNotasFiscais() {
        while (true) {
            try {
                System.out.println("\nGerenciador de Notas Fiscais:");
                System.out.println("1. Criar NFe");
                System.out.println("2. Excluir NFe");
                System.out.println("3. Mostrar NFe");
                System.out.println("4. Consultar total vendido");
                System.out.println("5. Adicionar item na NFe");
                System.out.println("6. Remover item da NFe");
                System.out.println("7. Editar NFe");
                System.out.println("0. Voltar ao menu principal");
                System.out.print("\nDigite a opção: ");

                int opcao = scanner.nextInt();
                scanner.nextLine();  // Consume newline left-over

                switch (opcao) {
                    case 1://add nf
                        criaNFe();
                        break;
                    case 2://excluir nf
                        excluiNFe();
                        break;
                    case 3://mostrar nf
                        mostraNFe();
                        break;
                    case 4:// consulta total de vendas
                        totalVendas();
                        break;
                    case 5://add item na nf
                        addItemNFe();
                        break;
                    case 6: //remover item da nf
                        removeItemNFe();
                        break;
                    case 7: //editar nf
                        editaNFe();
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
