package ProjetoLivro;

public class Livro implements Publicacao{

    //atributos
    private String titulo;
    private String autor;
    private int totPaginas;
    private int pagAtual;
    private boolean aberto;
    private Pessoa leitor;

    //metodos publicos

    public void detalhes(){
        System.out.println("=========DETALHES========");
        System.out.println("Título: " + this.getTitulo());
        System.out.println("Autor: " + this.getAutor());
        System.out.println("Total de Páginas: " + this.getTotPaginas());
        System.out.println("Página Atual: " + this.getPagAtual());
        System.out.println("Leitor: " + this.getLeitor());
        System.out.println("Aberto? " + this.isAberto());
        System.out.println("--------------------------");
    }

    //metodos especiais

    //construtor
    public Livro(String titulo, String autor,
                 int totPaginas, Pessoa leitor) {

        this.titulo = titulo;
        this.autor = autor;
        this.totPaginas = totPaginas;
        this.pagAtual = 0;
        this.aberto = false;
        this.leitor = leitor;
    }


    //get & set

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getTotPaginas() {
        return totPaginas;
    }

    public void setTotPaginas(int totPaginas) {
        this.totPaginas = totPaginas;
    }

    public int getPagAtual() {
        return pagAtual;
    }

    public void setPagAtual(int pagAtual) {
        this.pagAtual = pagAtual;
    }

    public boolean isAberto() {
        return aberto;
    }

    public void setAberto(boolean aberto) {
        this.aberto = aberto;
    }

    public String getLeitor() {
        return leitor.getNome();
    }

    public void setLeitor(Pessoa leitor) {
        this.leitor = leitor;
    }

    //metodos abstratos

    @Override
    public void abrir() {
        //this.setAberto(true);
        this.aberto= true;
        System.out.println("Livro " + this.getTitulo() + " aberto por " + this.getLeitor());
    }

    @Override
    public void fechar() {
        //this.setAberto(false);
        this.aberto= false;
        System.out.println("Livro " + this.getTitulo() + " fechado por " + this.getLeitor());

    }

    @Override
    public void folhear(int p) {
        if (isAberto()){
            if(p < getTotPaginas()){
            this.setPagAtual(getPagAtual()+p);
            System.out.println("Livro " + this.getTitulo() + " folheado por " + this.getLeitor() + " em " + p + " paginas");
            }else{
                System.out.println("Página inválida do livro " + this.getTitulo() + " , " + this.getLeitor() + " não foi possível folhear");
            }

            }
        else {
            System.out.println("Impossivel folhear livro fechado");
        }
    }

    @Override
    public void avancarPag() {
            if (isAberto()){
                if (this.getPagAtual() == (this.getTotPaginas())){
                    System.out.println("Fim do livro");
                }else {
                    this.setPagAtual(getPagAtual()+1);
                }
            } else {
                System.out.println("Impossivel avançar pagina de livro fechado");
            }
    }

    @Override
    public void voltarPag() {
        if (isAberto()){
        if (this.getPagAtual()<=0){
            System.out.println("Inicio do livro");
        }else{
            this.setPagAtual(getPagAtual()-1);
        }
    } else {
        System.out.println("Impossivel voltar pagina de livro fechado");
    }
    }
}
