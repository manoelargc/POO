package BancoDeMidias;
public class IteratorListaEncadeada<TIPO> {
        private Nodo<TIPO> nodo;

        public IteratorListaEncadeada(Nodo<TIPO> atual){
            this.nodo = atual;
        }

        public boolean temProximo(){
            if (nodo.getProximo() == null){
                return false;
            }else{
                return true;
            }
        }

        public Nodo<TIPO> getProximo(){
            nodo = nodo.getProximo();
            return nodo;
        }
}
