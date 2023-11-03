package BancoDeMidias;

public class Foto extends Midia {
    //atributos
    private String fotografo;
    private String pessoas;
    private String local;
    private int dia;
    private int mes;

    //metodos publicos
    public String data(){
            return getDia() + "/" + getMes() + "/" + getAno();
        }

    //metodos especiais

    //construtor
/*    public Foto(String fotografo, String pessoas, String local, int dia, int mes) {
        this.fotografo = fotografo;
        this.pessoas = pessoas;
        this.local = local;
        this.dia = dia;
        this.mes = mes;

    }*/

    //get e set
    public String getFotografo() {
        return fotografo;
    }

    public void setFotografo(String fotografo) {
        this.fotografo = fotografo;
    }

    public String getPessoas() {
        return pessoas;
    }

    public void setPessoas(String pessoas) {
        this.pessoas = pessoas;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    //toString
    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Fotógrafo: " + getFotografo() + "\n" +
                "Pessoas: " + getPessoas() + "\n" +
                "Local: " + getLocal() + "\n" +
                "Data: " + data();
    }
}


