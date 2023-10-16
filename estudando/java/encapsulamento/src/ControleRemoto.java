public class ControleRemoto implements Controlador {
    
    //atributos
    private int volume;
    private boolean ligado;
    private boolean tocando;


    //metodos especiais

    public ControleRemoto() {
        this.volume = 50;
        this.ligado = false;
        this.tocando = false;
    }

    //get & set

    //volume
    private int getVolume() {
        return volume;
    }

    private void setVolume(int volume) {
        this.volume = volume;
    }

    //ligado
    private boolean getLigado() {
        return ligado;
    }

    private void setLigado(boolean ligado) {
        this.ligado = ligado;
    }

    //tocando
    private boolean getTocando() {
        return tocando;
    }

    private void setTocando(boolean tocando) {
        this.tocando = tocando;
    }

    //-----------------------------------
    
    //metodos abstratos
    //(sobreescrevendo metodos da interface, pra programar aqui)


    @Override
    public void ligar(){
        this.setLigado(true);
    }

    @Override
    public void desligar(){
        this.setLigado(false);
    }

    @Override
    public void abrirMenu(){
        System.out.println("Está ligado? " + this.getLigado());
        System.out.println("Está tocando? " + this.getTocando());
        System.out.print("Volume: " + this.getVolume());

        for (int i=0; i<=this.getVolume(); i+=10){
            System.out.print("|");
        }
    }

    @Override
    public void fecharMenu(){
        System.out.println("Fechando menu...");
        
    }

    @Override
    public void maisVolume(){
        if (this.getLigado()){ //verificar se ta ligado
            this.setVolume(this.getVolume()+5);
        }
    }

    @Override
    public void menosVolume(){
        if (this.getLigado()){
            this.setVolume(this.getVolume()-5);
        }
    }

    @Override
    public void ligarMudo(){
        if (this.getLigado() && this.getVolume()>0){
            this.setVolume(0);
        }
    }

    @Override
    public void desligarMudo(){
        if (this.getLigado() && this.getVolume() == 0){
            this.setVolume(50);
        }
        
    }

    @Override
    public void play(){
        if (this.getLigado() && !(this.getTocando())){
            this.setTocando(true);
        }

    }

    @Override
    public void pause(){
        if(this.getLigado() && this.getTocando()){
            this.setTocando(false);
        }
        
    }



}