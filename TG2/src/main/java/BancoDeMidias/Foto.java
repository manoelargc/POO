package BancoDeMidias;

import java.util.Arrays;

public class Foto extends Midia {
        //atributos
        private String fotografo;
        private String[] pessoas;
        private int numPessoas; // contador para o número de pessoas
        private String local;
        private int dia;
        private int mes;

        public Foto(String titulo, String data) {
            super(titulo,data);
            setTitulo(titulo);
            data=data();
            pessoas = new String[10];
            numPessoas=0;
        }

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



        //toString
        @Override
        public String toString() {
            return super.toString() + "\n" +
                    "Fotógrafo: " + getFotografo() + "\n" +
                    "Pessoas: " + Arrays.toString(getPessoas()) + "\n" +
                    "Local: " + getLocal() + "\n" +
                    "Data: " + data() + "\n";
        }
    }




