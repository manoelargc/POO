package BancoDeMidias;


/**
 * A classe Multimidia é uma extensão da classe abstrata Midia e representa uma mídia multimídia no sistema.
 * Contém informações específicas como gênero, idioma e duração.

 * @author Manoela Resende
 * @author Eduarda Sifuentes
 */
public class Multimidia extends Midia {
    //atributos
    private String genero;
    private String idioma;
    private int horas;
    private int minutos;
    private int segundos;

    /**
     * Construtor da classe Multimidia.
     *
     * @param titulo O título da multimídia.
     * @param genero O gênero da multimídia.
     */

    public Multimidia(String titulo, String genero) {
        super();
        setTitulo(titulo);
        setGenero(genero);
    }


    /**
     * Obtém uma representação da duração da multimídia.
     *
     * @return Uma string representando a duração no formato adequado.
     */
    public String getDuracao(){
        if (getHoras(horas) == 0 && getMinutos(minutos)>0){
            return getMinutos(minutos) + " min e " + getSegundos(segundos) + " segundos";
        } else if (getMinutos(minutos)==0) {
            return getSegundos(segundos) + " segundos";
        }
        else {
            return getHoras(horas) + " horas " + getMinutos(minutos) + " min e " + getSegundos(segundos) + " segundos";
        }
    }



    //get e set

    public void setDuracao(int horas, int minutos, int segundos){
        this.setHoras(horas);
        this.setMinutos(minutos);
        this.setSegundos(segundos);
    }
    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public int getHoras(int horas) {
        return this.horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getMinutos(int minutos) {
        return this.minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getSegundos(int segundos) {
        return this.segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }


    /**
     * Converte a instância da classe Multimidia para uma representação em String.
     *
     * @return Uma representação em String dos atributos da classe Multimidia.
     */

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Gênero: " + getGenero() + "\n" +
                "Idioma: " + getIdioma() + "\n" +
                "Duração: " + getDuracao();
    }

    /**
     * @return tipo de midia pra classificar as tabelas no app da interface do usuario
     */
    @Override
    public String getTipo() {
        return "Multimidia";
    }

}
