package BancoDeMidias;
public class IteratorListaEncadeada<TIPO> {
        private Nodo<TIPO> nodo;

        public IteratorListaEncadeada(Nodo<TIPO> atual){
            this.nodo = atual;
        }

    public boolean temProximo() {
        if (this.nodo == null) {
            return false;
        } else {
            return this.nodo.getProximo() != null;
        }
    }


        public Nodo<TIPO> getProximo(){
            nodo = nodo.getProximo();
            return nodo;
        }
}
