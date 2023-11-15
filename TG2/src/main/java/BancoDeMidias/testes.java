package BancoDeMidias;

public class testes {
    public static void main(String[] args) {
/*            Foto foto = new Foto();
            foto.setAno(2027);
            //System.out.println(foto.data());
            System.out.println(foto);

            Multimidia m= new Multimidia();

            m.setHoras(2);
            m.setMinutos(5);
            m.setSegundos(30);
            //System.out.println(m.duracao());
            System.out.println(m);*/

/*        ListaEncadeada<Midia> lista = new ListaEncadeada<Midia>();

        lista.add("Manu");
        lista.add("Rafa");
        //lista.add("Eduarda");
        lista.remove("Manu");
        System.out.println(lista.getTamanho());*/

        //----------------------------------------------------

/*

        // Cria um novo catálogo
        Catalogo catalogo = new Catalogo();

        // Cria algumas mídias

// Cria uma nova foto
        Foto foto = new Foto("crf", 1, 1, 2023);

// Define os atributos da foto
        foto.setFotografo("manu");
        foto.setDescricao("oioi");
        foto.setPessoas(new String[]{"Pessoa 1", "Pessoa 2", "Pessoa 3"});
        foto.setLocal("rj");
        foto.setDia(1);
        foto.setMes(1);
        foto.setAno(2023);

// Insere a foto no catálogo
        catalogo.insere(foto);


        Musica musica = new Musica("Título da Música", "Gênero da Música");
        // Define os atributos da música
        musica.setCompositores("Compositor da Música");
        musica.setInterpretes("Intérprete da Música");

        // Insere as mídias no catálogo
        catalogo.insere(foto);
        catalogo.insere(musica);

        // Mostra todas as mídias no catálogo
        catalogo.mostra();

        // Consulta uma mídia por título
        Midia midia = catalogo.consultaPorTitulo("crf");
        if (midia != null) {
            System.out.println("Mídia encontrada:" + midia.toString());
        } else {
            System.out.println("Mídia não encontrada.");
        }*/

        //------------------------------------------------
        // Deleta uma mídia
        //catalogo.delete("Título da Música");

        // Mostra todas as mídias no catálogo após as operações de edição e exclusão
/*        catalogo.insere(foto);
        catalogo.insere(musica);

        catalogo.mostra();*/

        //------------
     /*   // Cria um novo catálogo
        Catalogo catalogo = new Catalogo();

        // Cria um novo leitor de CSV
        LeitorCSV leitor = new LeitorCSV();

        // Lê o arquivo CSV e obtém a lista de mídias
        IListaEncadeada<Midia> midias = leitor.lerArquivo("C:\\Users\\manor\\OneDrive\\Documentos\\GitHub\\POO\\TG2\\src\\main\\java\\BancoDeMidias\\CSV\\teste.csv");

        // Adiciona todas as mídias do CSV ao catálogo
        IteratorListaEncadeada<Midia> iterator = midias.getIterator();
        while (iterator.temProximo()) {
            Midia midia = iterator.getProximo().getValor();
            catalogo.insere(midia);
        }




        // Mostra todas as mídias do catálogo
        catalogo.mostra();*/

          /*  LeitorCSV leitor = new LeitorCSV();
            ListaEncadeada<Midia> midias = leitor.lerArquivo("C:\\\\Users\\\\manor\\\\OneDrive\\\\Documentos\\\\GitHub\\\\POO\\\\TG2\\\\src\\\\main\\\\java\\\\BancoDeMidias\\\\CSV\\\\teste.csv");

            // Crie um catálogo
            ICatalogo catalogo = new Catalogo();

            // Insira cada mídia no catálogo
            IteratorListaEncadeada<Midia> iterator = midias.getIterator();
            while (iterator.temProximo()) {
                catalogo.insere(iterator.getProximo().getValor());
            }

            // Verifique se as mídias foram inseridas corretamente
            catalogo.mostra();*/

/*        LeitorCSV leitor = new LeitorCSV();
        leitor.testarLeituraEInsercao();
        }*/

        // Cria um novo catálogo
        Catalogo catalogo = new Catalogo();

        // Cria um novo leitor CSV
        LeitorCSV leitor = new LeitorCSV();

        // Lê as mídias do arquivo e as adiciona ao catálogo
        ListaEncadeada<Midia> midias = leitor.lerArquivo("C:\\\\Users\\\\manor\\\\OneDrive\\\\Documentos\\\\GitHub\\\\POO\\\\TG2\\\\src\\\\main\\\\java\\\\BancoDeMidias\\\\CSV\\\\midia.csv");
        for (int i = 0; i < midias.getTamanho(); i++) {
            Midia midia = (Midia) midias.get(i).getValor();
            catalogo.insere(midia);
        }

        // Mostra todas as mídias no catálogo
        catalogo.mostra();

        // Consulta uma mídia por título
        Midia midia = catalogo.consultaPorTitulo("crf");
        if (midia != null) {
            System.out.println("Mídia encontrada:" + midia.toString());
        } else {
            System.out.println("Mídia não encontrada.");
        }
    }

    }




