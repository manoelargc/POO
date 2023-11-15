package BancoDeMidias;
/**
 * Classe abstrata Midia que serve como base para outras classes de mídia
 *
 * @author Manoela Resende
 * @author Eduarda Sifuentes
 */
public abstract class Midia {

    // Atributos
    private String titulo;
    private String descricao;
    private int ano;
    private String imageUrl;

    /**
     * Construtor padrão/vazio da classe Midia
     */
    public Midia() {
    }


    /**
     * Construtor da classe Midia.
     *
     * @param titulo o título da mídia
     * @param ano ano da mídia
     */
    public Midia(String titulo, int ano) {
        this.titulo = titulo;
        this.ano = ano;
        this.descricao= getDescricao();
    }


    // Getters e setters

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

    /**
     * Método toString para representação em String da classe Midia
     *
     * @return Uma representação pra retornar em String os atributos de Midia
     */
    public String toString() {
        return "\nImagem: " + getImageUrl() + "\n" +
                "Título: " + getTitulo() + "\n" +
                "Descrição: " + getDescricao() + "\n" +
                "Ano: " + getAno();
    }
}
