package Q1.A;

public abstract class Produtos {
    //atributos
    private int codigo;
    private String nome;
    private float valor;

    //metodos especiais

/*
    //construtor
    public Produtos(int codigo, String nome, float valor) {
        this.codigo = codigo;
        this.nome = nome;
        this.valor = valor;
    }
*/


    //get & set


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

/*    @Override
    public String toString() {
        return "Produto{" +
                "codigo='" + codigo + '\'' +
                ", nome=" + nome +
                ", valor='" + valor + '\'' +
                '}';
    }*/
}
