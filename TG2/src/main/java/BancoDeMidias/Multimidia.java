package BancoDeMidias;

public class Multimidia extends Midia {
    //atributos
    private String genero;
    private String idioma;
    private int horas;
    private int minutos;
    private int segundos;

    public Multimidia(String titulo, String genero) {
        super();
        setTitulo(titulo);
        setGenero(genero);
    }

    //metodos publicos
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

    //metodos especiais
    //constructor
/*    public Multimidia(String genero, String idioma, int horas, int minutos, int segundos) {
        this.genero = genero;
        this.idioma = idioma;
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }*/

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

    //toString
    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Gênero: " + getGenero() + "\n" +
                "Idioma: " + getIdioma() + "\n" +
                "Duração: " + getDuracao();
    }

    @Override
    public String getTipo() {
        return "Multimidia";
    }

}
