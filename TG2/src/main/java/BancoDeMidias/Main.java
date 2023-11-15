package BancoDeMidias;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Catalogo catalogo = new Catalogo();
        catalogo.carregaDados("C:\\Users\\manor\\OneDrive\\Documentos\\GitHub\\POO\\TG2\\src\\main\\java\\BancoDeMidias\\CSV\\midia.csv");

        boolean sair = false;
        while (!sair) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Cadastrar nova mídia");
            System.out.println("2. Exibir mídias");
            System.out.println("3. Editar mídia");
            System.out.println("4. Excluir mídia");
            System.out.println("5. Consultar mídias por título");
            System.out.println("6. Consultar todas as mídias em ordem de data");
            System.out.println("7. Pesquisar músicas e filmes por gênero");
            System.out.println("8. Sair");
            System.out.print("Digite sua escolha: ");
            String escolha = scanner.nextLine();
            switch (escolha) {
                case "1":
                    System.out.println("Qual o tipo da mídia que você deseja inserir? (Foto, Filme, Musica)");
                    String tipo = scanner.nextLine();
                    System.out.println("Digite os campos da mídia separados por #:");
                    //String[] campos = scanner.nextLine().split(",");
                    String linha = tipo+"#"+scanner.nextLine();
                    String[] campos = linha.split("#");
                    //campos[0] = tipo;
                    System.out.println("campos: " + Arrays.toString(campos));
                    if (tipo.equalsIgnoreCase("Foto")) {
                        Foto foto = LeitorCSV.criarFoto(campos);
                        catalogo.insere(foto);
                    } else if (tipo.equalsIgnoreCase("Filme")) {
                        System.out.println("Título#Descricao#AnoLançamento#Gênero#Idioma#Horas#Minutos#Segundos#Diretor#Elenco#URL Imagem");
                        Filme filme = LeitorCSV.criarFilme(campos);
                        catalogo.insere(filme);
                    } else if (tipo.equalsIgnoreCase("Musica")) {
                        Musica musica = LeitorCSV.criarMusica(campos);
                        catalogo.insere(musica);
                    }
                    break;

                case "2":
                    catalogo.mostra();
                    break;
                case "3":
                    System.out.print("Digite o título da mídia que você deseja editar: ");
                    String tituloEditar = scanner.nextLine();
                    System.out.print("Digite o campo da mídia que você deseja editar: ");
                    String campoEditar = scanner.nextLine();
                    System.out.print("Digite o novo valor do campo " + campoEditar +" : ");
                    String novoValor = scanner.nextLine();
                    catalogo.editar(tituloEditar, campoEditar,novoValor);
                    break;
                case "4":
                    System.out.print("Digite o título da mídia que você deseja excluir: ");
                    String tituloExcluir = scanner.nextLine();
                    catalogo.delete(tituloExcluir);
                    break;
                case "5":
                    System.out.print("Digite o título da mídia que você deseja consultar: ");
                    String titulo = scanner.nextLine();
                    catalogo.consultaPorTitulo(titulo);
                case "6":
                    System.out.print("Digite a data que você deseja pesquisar: ");
                    String data = scanner.nextLine();
                    catalogo.consultaPorData(data);
                    break;
                case "7":
                    System.out.print("Digite o gênero que você deseja pesquisar: ");
                    String genero = scanner.nextLine();
                    catalogo.consultaPorGenero(genero);
                    break;
                case "8":
                    System.out.println("Saindo...");
                    sair = true;
                    break;
                default:
                    System.out.println("Escolha inválida. Por favor, tente novamente.");
                    break;
            }
        }
        scanner.close();
    }
}
