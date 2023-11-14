package BancoDeMidias;

public abstract class Midia {

    //atributos
    private String path;
    private String titulo;
    private String descricao;
    private int ano;

    private String imageUrl;

    public Midia(String titulo, String data) {
    }

    public Midia() {

    }

    //get e set

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public String getImageUrl() {
        return imageUrl;
    }

    //toString
    public String toString() {
        return "\nTítulo: " + getTitulo() + "\n" +
                "Descrição: " + getDescricao() + "\n" +
                "Ano: " + getAno();
    }

}
