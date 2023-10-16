
public class ContaBanco {

    public int numConta;
    protected String tipo;
    private String dono;
    private float saldo;
    private boolean status;

    public ContaBanco() {

        this.setSaldo(0);
        this.status=false;
    }

/*
    public ContaBanco(int numConta, String tipo, String dono, float saldo) {
        this.numConta = numConta;
        this.tipo = tipo;
        this.dono = dono;
        this.saldo = saldo;
        this.status = status;
    }
*/

//metodos


    public void estadoAtual(){
        System.out.println("------------------------------------");
        System.out.println("Conta: " + this.getNumConta());
        System.out.println("Tipo: " + this.getTipo());
        System.out.println("Dono: " + this.getDono());
        System.out.println("Saldo: " + this.getSaldo());

    }
    public void abrirConta(String tipo) {
        this.setTipo(tipo);
        this.setStatus(true);
        if (tipo == "cc") {
            this.setSaldo(50.0f);
        } else if (tipo == "cp") {
            this.setSaldo(150.0f);
        }

        System.out.println("Conta aberta com sucesso");
    }

    public void fecharConta() {
        if (this.getSaldo() > 0.0f) {
            System.out.println("Conta com dinheiro");
        } else if (this.getSaldo() < 0.0f) {
            System.out.println("Conta em debito");
        } else {
            setStatus(false);
            System.out.println("Conta fechada com sucesso");
        }
    }

    public void depositar(float valor) {
        if (this.getStatus()) {
            this.setSaldo(this.getSaldo() + valor);
            System.out.println("Deposito realizado na conta de " + this.getDono());
        } else {
            System.out.println("Impossivel depositar em uma conta fehcada");
        }
    }

    public void sacar(float valor) {
        if (this.getStatus()) {
            if (this.getSaldo() >= valor) {
                this.setSaldo(this.getSaldo() - valor);
                System.out.println("Saque realizado na conta de " + this.getDono());

            } else {
                System.out.println("Saldo insuficiente para saque");
            }
        }
        System.out.println("Impossivel sacar em uma conta fehcada");
    }



    public void pagarMensal() {
        int valor=0;

        if (this.getTipo() == "cc"){
            valor = 12;
        }else if (this.getTipo() == "cp"){
            valor = 20;
        }

        if(this.getStatus()){
            this.setSaldo(this.getSaldo - valor);
            System.out.println("Mensalidade paga com sucesso por" + this.getDono());
        }
        else {
            System.out.println("Impossivel pagar conta fechada");
        }

    }

//get & set
//numero da conta
    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

//tipo de conta
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

//dono
    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

//saldo
    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

//status
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
