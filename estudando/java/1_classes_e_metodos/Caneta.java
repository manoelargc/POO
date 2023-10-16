public class Caneta{
    public String modelo;
    public String cor;
    private float ponta;
    protected int carga;
    protected boolean tampada;

    //constructor
    public Caneta(String modelo, String cor, float ponta, int carga) {
        this.modelo = modelo;
        this.cor = cor;
        this.ponta = ponta;
        this.carga = carga;
        this.tampar();
    }

    //--------------------------
    //getter & setter methods
    //--------------------------

    //modelo
    public String getModelo(){
        return this.modelo;
    }

    public void setModelo(String m){
        this.modelo= m;
    }

    //cor
    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    //ponta
    public float getPonta() {
        return ponta;
    }

    public void setPonta(float ponta) {
        this.ponta = ponta;
    }

    //carga
    public int getCarga() {
        return carga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }




    //metodos

    //status
    public void status(){
        System.out.println("Uma caneta: " + this.cor);
        System.out.println("Ponta: " + this.ponta);
        System.out.println("Carga: " + this.carga);
        System.out.println("Está tampada? " + this.tampada);        

    }
    
    public void rabiscar(){
        if(this.tampada==true){
            System.out.println("Erro! Não pode rabiscar tampada");
        }else{
            System.out.println("Rabiscando");
        }
        
    }

    protected void tampar(){
        this.tampada=true;
    }

    protected void destampar(){
        this.tampada=false;
    }
}