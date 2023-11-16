package BancoDeMidias;
/**
 * A classe abstrata Midia serve como uma classe base para outros tipos de mídia no sistema.
 * 
 * @author Manoela Resende
 * @author Eduarda Sifuentes
 */
public abstract class Midia {
     //ATRIBUTOS
    private String titulo;
    private String descricao;
    private int ano;
    private String imageUrl;

    /**
    * Construtor padrão/vazio da classe Midia.
    */
    public Midia() {
    }


    /**
    * Construtor da classe Midia.
    *
    * @param titulo O título da mídia.
    * @param ano    O ano da mídia.
    */
    public Midia(String titulo, int ano) {
        this.titulo = titulo;
        this.ano = ano;
        this.descricao= getDescricao();
    }


    //GETTERS E SETTERS
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

    /**
    * Define a URL da imagem da mídia.
    *
    * @param imageUrl A URL da imagem.
    */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
    * Obtém a URL da imagem da mídia.
    *
    * @return A URL da imagem.
    */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
    * Converte a instância da classe Midia para uma representação em String.
    *
    * @return Uma representação em String dos atributos da classe Midia.
    */
    public String toString() {
        return "\nImagem: " + getImageUrl() + "\n" +
                "Título: " + getTitulo() + "\n" +
                "Descrição: " + getDescricao() + "\n" +
                "Ano: " + getAno();
    }
}
