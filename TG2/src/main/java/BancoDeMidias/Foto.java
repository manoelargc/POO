package BancoDeMidias;

import java.util.Arrays;

/**
 * Classe Foto que estende a classe Midia.
 *
 * @author Manoela Resende
 * @author Eduarda Sifuentes
 */
public class Foto extends Midia {
    // Atributos
    private String fotografo;
    private String[] pessoas;
    private int numPessoas;
    private String local;
    private int dia;
    private int mes;

    /**
     * Construtor da classe Foto.
     *
     * @param titulo título da foto
     * @param dia    dia em que a foto foi tirada
     * @param mes    mês em que a foto foi tirada
     * @param ano    ano em que a foto foi tirada
     */
    public Foto(String titulo, int dia, int mes, int ano) {
        super(titulo, ano);
        this.setDia(dia);
        this.setMes(mes);
    }

    // Métodos públicos

    /**
     * Método para obter a getData em que a foto foi tirada
     *
     * @return A getData em que a foto foi tirada
     */
    public String getData() {
        return getDia() + "/" + getMes() + "/" + getAno();
    }

    // Getters e setters

    public String getFotografo() {
        return fotografo;
    }

    public void setFotografo(String fotografo) {
        this.fotografo = fotografo;
    }

    public String[] getPessoas() {
        return pessoas;
    }

    public void setPessoas(String[] pessoas) {
        this.pessoas = pessoas;
        this.numPessoas = pessoas.length;
    }

    public void setData(int dia, int mes, int ano) {
        this.setDia(dia);
        this.setMes(mes);
        this.setAno(ano);
    }

    /**
     * Método para adicionar uma pessoa à foto
     *
     * @param pessoa A pessoa a ser adicionada
     */
    public void addPessoa(String pessoa) {
        if (numPessoas < pessoas.length) {
            this.pessoas[numPessoas] = pessoa;
            numPessoas++;
        } else {
            System.out.println("Não é possível adicionar mais pessoas. O array está cheio.");
        }
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

    /**
     * Método toString para representação em String da classe Foto
     *
     * @return Uma representação em String da classe Foto, juntando
     * com as informações da classe midia
     */
    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Fotógrafo: " + getFotografo() + "\n" +
                "Pessoas: " + Arrays.toString(getPessoas()) + "\n" +
                "Local: " + getLocal() + "\n" +
                "Data: " + getData() + "\n";
    }
}

