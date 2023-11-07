package BancoDeMidias;

public class Multimidia extends Midia {
    //atributos
    private String genero;
    private String idioma;
    private int horas;
    private int minutos;
    private int segundos;

    //metodos publicos
    public String getDuracao(){
        if (getHoras() == 0 && getMinutos()>0){
            return getMinutos() + " min e " + getSegundos() + " segundos";
        } else if (getMinutos()==0) {
            return getSegundos() + " segundos";
        }
        else {
            return getHoras() + " horas " + getMinutos() + " min e " + getSegundos() + " segundos";
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

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getSegundos() {
        return segundos;
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

}
