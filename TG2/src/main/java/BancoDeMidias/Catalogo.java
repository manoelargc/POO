package BancoDeMidias;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Catalogo implements ICatalogo {
    private IListaEncadeada<Midia> midias;

    public Catalogo() {
        midias = new ListaEncadeada<>();
    }

    @Override
    public void carregaDados(String path) {
        LeitorCSV leitor = new LeitorCSV();
        ListaEncadeada<Midia> midias = leitor.lerArquivo(path);
        for (int i = 0; i < midias.getTamanho(); i++) {
            Midia midia = (Midia) midias.get(i).getValor();
            this.insere(midia);
        }
    }

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



}