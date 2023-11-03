package BancoDeMidias;

public class Multimidia extends Midia {
    //atributos
    private String genero;
    private String idioma;
    private int horas;
    private int minutos;
    private int segundos;

    //metodos publicos
    public String duracao(){
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
}
