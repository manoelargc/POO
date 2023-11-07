package BancoDeMidias;

public class testes {
        public static void main(String[] args) {
            Foto foto = new Foto();
            foto.setAno(2027);
            //System.out.println(foto.data());
            System.out.println(foto);

            Multimidia m= new Multimidia();

            m.setHoras(2);
            m.setMinutos(5);
            m.setSegundos(30);
            //System.out.println(m.duracao());
            System.out.println(m);

            ListaEncadeada<String> lista = new ListaEncadeada<String>();

            lista.add("Manu");
            lista.add("Rafa");
            lista.add("Eduarda");
            lista.remove("Manu");
            System.out.println(lista.getTamanho());

        }
    }

