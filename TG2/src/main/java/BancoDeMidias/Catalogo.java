package BancoDeMidias;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Classe que representa um catálogo de mídias.
 *
 * @author Manoela Resende
 * @author Eduarda Sifuentes
 */
public class Catalogo implements ICatalogo {
    private IListaEncadeada<Midia> midias;

    public Catalogo() {
        midias = new ListaEncadeada<>();
    }



    /**
     * Utiliza um objeto LeitorCSV para ler dados de um arquivo A leitura resulta em uma lista encadeada de mídias.
     * Por meio de um loop é inserida no catálogo utilizando o método insere.
     *
     * @param path O caminho do arquivo a ser lido.
     */
    @Override
    public void carregaDados(String path) {
        LeitorCSV leitor = new LeitorCSV();
        ListaEncadeada<Midia> midias = leitor.lerArquivo(path);
        for (int i = 0; i < midias.getTamanho(); i++) {
            Midia midia = (Midia) midias.get(i).getValor();
            this.insere(midia);
        }
    }

    /**
     * adiciona uma mídia ao catálogo. Antes de realizar a adição, imprime uma mensagem
     * indicando a mídia que está sendo inserida.
     * O método chama o método add da lista encadeada para efetuar a inserção da mídia.
     * Após a inserção, verifica se a lista está vazia e exibe uma mensagem correspondente,
     * ou informa que o item foi inserido com sucesso.
     *
     * @param midia A mídia a ser inserida no catálogo.
     */
    @Override
    public void insere(Midia midia) {
        System.out.println("Inserindo: " + midia.getTitulo());  // Adicione esta linha para depuração
        midias.add(midia);
        if (midias.estaVazia()) {
            System.out.println("A lista está vazia após a inserção.");
        } else {
            System.out.println("Item inserido com sucesso. O tamanho atual do catálogo é: " + midias.getTamanho());
        }
    }


    /**
     * O método mostra exibe as informações de todas as mídias no catálogo, ou informa que o catálogo está vazio.
     */
    @Override
    public void mostra() {
        if (!midias.estaVazia()) {
            IteratorListaEncadeada<Midia> iterator = midias.getIterator();
            while (iterator.temProximo()) {
                Midia midia = iterator.getProximo().getValor();
                System.out.println(midia.toString());
            }
        } else {
            System.out.println("O catálogo está vazio.");
        }
    }


    /**
     * Consulta uma mídia no catálogo pelo título.
     * Verifica se o catálogo não está vazio e, se não estiver, itera sobre as mídias procurando
     * aquela com o título correspondente. Se encontrada, imprime suas informações e retorna a mídia.
     * Caso contrário, imprime que a mídia não foi encontrada. Se o catálogo estiver vazio,
     * informa que está vazio e retorna null.
     *
     * @param titulo O título da mídia a ser consultada.
     * @return A mídia encontrada ou null se não encontrada.
     */
    @Override
    public Midia consultaPorTitulo(String titulo) {
        if (!midias.estaVazia()) {
            Midia respostaMidia = null;
            IteratorListaEncadeada<Midia> iterator = midias.getIterator();
            while (iterator.temProximo()) {
                Midia midia = iterator.getProximo().getValor();
                if (midia.getTitulo().equalsIgnoreCase(titulo)) {
                    System.out.println("Mídia encontrada:" + midia.toString());
                    respostaMidia = midia;
                }
            }
            if (respostaMidia != null){
                return respostaMidia;
            } else {
                System.out.println("Midia não encontrada.");
            }
        } else {
            System.out.println("O catálogo está vazio.");

        }
        return null;
    }

    /**
     * Edita informações de uma mídia no catálogo com base no título fornecido.
     * Itera sobre as mídias no catálogo procurando aquela com o título correspondente.
     * Se encontrada, realiza a edição do campo especificado com o novo valor.
     * Os campos disponíveis para edição dependem do tipo de mídia (Foto, Filme, ou Musica).
     * Imprime mensagens informativas ou de erro conforme necessário.
     *
     * @param titulo     O título da mídia a ser editada.
     * @param campo      O campo a ser editado.
     * @param novoValor  O novo valor a ser atribuído ao campo.
     */
    public void editar(String titulo, String campo, String novoValor) {
        if (!midias.estaVazia()) {
            IteratorListaEncadeada<Midia> iterator = midias.getIterator();
            while (iterator.temProximo()) {
                Midia midia = iterator.getProximo().getValor();
                if (midia.getTitulo().equalsIgnoreCase(titulo)) {
                    switch (campo.toLowerCase()) {
                        case "titulo":
                            midia.setTitulo(novoValor);
                            break;
                        case "descricao":
                            midia.setDescricao(novoValor);
                            break;
                        case "ano":
                            int novoInt = Integer.parseInt(novoValor);
                            midia.setAno(novoInt);
                            break;
                        case "imagem":
                            midia.setImageUrl(novoValor);
                            break;
                        case "fotografo":
                            if (midia instanceof Foto){
                            ((Foto) midia).setFotografo(novoValor);
                            }
                            break;
                        case "pessoas":
                            if (midia instanceof Foto){
                                String[] novoVetorP = new String[]{novoValor};
                                ((Foto) midia).setPessoas(novoVetorP);
                            }
                            break;
                        case "data":
                            if (midia instanceof Foto) {
                                String[] partes = novoValor.split("/");
                                if (partes.length == 3) {
                                    int horas = Integer.parseInt(partes[0]);
                                    int minutos = Integer.parseInt(partes[1]);
                                    int segundos = Integer.parseInt(partes[2]);
                                    ((Foto) midia).setData(horas, minutos, segundos);
                                } else {
                                    System.out.println("Formato de duração inválido. Use o formato dd/mm/aaaa.");
                                }
                            }
                            break;
                        case "genero":
                            if (midia instanceof Multimidia){
                                ((Multimidia) midia).setGenero(novoValor);
                            }
                            break;
                        case "idioma":
                            if (midia instanceof Multimidia){
                                ((Multimidia) midia).setIdioma(novoValor);
                            }
                            break;
                        case "duracao":
                            if (midia instanceof Multimidia) {
                                String[] partes = novoValor.split(":");
                                if (partes.length == 3) {
                                    int horas = Integer.parseInt(partes[0]);
                                    int minutos = Integer.parseInt(partes[1]);
                                    int segundos = Integer.parseInt(partes[2]);
                                    ((Multimidia) midia).setDuracao(horas, minutos, segundos);
                                } else {
                                    System.out.println("Formato de duração inválido. Use o formato HH:MM:SS.");
                                }
                            }
                                break;

                        case "diretor":
                            if (midia instanceof Filme){
                                ((Filme) midia).setDiretor(novoValor);
                            }
                            break;
                        case "atores":
                            if (midia instanceof Filme){
                                String[] novoVetorP = new String[]{novoValor};
                                ((Filme) midia).setAtores(novoVetorP);
                            }
                            break;
                        case "compositores":
                            if (midia instanceof Musica){
                                String[] novoVetorP = new String[]{novoValor};
                                ((Musica) midia).setCompositores(novoVetorP);
                            }
                            break;
                        case "interpretes":
                            if (midia instanceof Musica){
                                String[] novoVetorP = new String[]{novoValor};
                                ((Musica) midia).setInterpretes(novoVetorP);
                            }
                            break;


                        default:
                            System.out.println("Campo inválido.");
                            break;
                    }
                    return;
                }
            }
        } else {
            System.out.println("O catálogo está vazio.");
        }
    }


    /**
     * remove uma mídia do catálogo com base no título fornecido.
     * Utiliza um loop para percorrer a lista encadeada, identifica a mídia com o título correspondente
     * e ajusta as referências do nó anterior e posterior para efetuar a remoção.
     * Atualiza também o tamanho do catálogo. Se a lista estiver vazia, informa que o catálogo está vazio.
     *
     * @param titulo O título da mídia a ser removida.
     */
    @Override
    public void delete(String titulo) {
        if (!midias.estaVazia()) {
            Nodo<Midia> anterior = null;
            Nodo<Midia> atual = midias.getPrimeiro();
            while (atual != null) {
                Midia midia = atual.getValor();
                if (midia.getTitulo().equalsIgnoreCase(titulo)) {
                    if (atual == midias.getPrimeiro()) {
                        midias.setPrimeiro(atual.getProximo());
                    } else if (atual == midias.getUltimo()) {
                        midias.setUltimo(anterior);
                        anterior.setProximo(null);
                    } else {
                        anterior.setProximo(atual.getProximo());
                    }
                    midias.setTamanho(midias.getTamanho() - 1);

                    return;
                }
                anterior = atual;
                atual = atual.getProximo();
            }
        } else {
            System.out.println("O catálogo está vazio.");
        }
    }

    /**
     * O método busca e exibe as fotos no catálogo que têm a data especificada,
     * criando uma lista resultado e iterando sobre as fotos para adicioná-las a essa lista.
     * Em seguida, imprime as informações das fotos encontradas ou informa que o catálogo está vazio.
     *
     * @param data A data a ser utilizada na consulta.
     */
    public void consultaPorData(String data) {
        IListaEncadeada<Midia> resultado = new ListaEncadeada<>();
        if (!midias.estaVazia()) {
            IteratorListaEncadeada<Midia> iterator = midias.getIterator();
            while (iterator.temProximo()) {
                Midia midia = iterator.getProximo().getValor();
                if (midia instanceof Foto) {
                    Foto foto = (Foto) midia;
                    if (foto.getData().equalsIgnoreCase(data)) {
                        resultado.add(foto);
                    }
                }
            }
            for (int i = 0; i < resultado.getTamanho(); i++) {
                Midia midia = (Midia) resultado.get(i).getValor();
                System.out.println(midia);
            }
        } else {
            System.out.println("O catálogo está vazio.");
        }
    }

    /**
     * O método consultaPorGenero itera sobre as mídias no catálogo por meio de um iterador.
     * Para cada mídia, verifica se é uma instância de Multimidia e, se for, compara o
     * gênero da multimídia com o gênero fornecido como parâmetro.
     *
     * @param genero genero a ser utilizada na consulta.
     */
    public void consultaPorGenero(String genero) {
        IListaEncadeada<Midia> resultado = new ListaEncadeada<>();
        if (!midias.estaVazia()) {
            IteratorListaEncadeada<Midia> iterator = midias.getIterator();
            while (iterator.temProximo()) {
                Midia midia = iterator.getProximo().getValor();
                if (midia instanceof Multimidia) {
                    Multimidia multimidia = (Multimidia) midia;
                    if (multimidia.getGenero().equalsIgnoreCase(genero)) {
                        resultado.add(multimidia);
                    }
                }
            }
            for (int i = 0; i < resultado.getTamanho(); i++) {
                Midia midia = (Midia) resultado.get(i).getValor();
                System.out.println(midia);
            }
        } else {
            System.out.println("O catálogo está vazio.");
        }
    }


    /**
     * Para retornar uma lista de midias e ser usado no app de interface do usuario
     *
     */
    public ListaEncadeada<Midia> getMidias() {
        return (ListaEncadeada<Midia>) midias;
    }

}