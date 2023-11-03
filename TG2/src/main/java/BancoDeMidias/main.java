package BancoDeMidias;

public class main {
        public static void main(String[] args) {
            Foto foto = new Foto("Manu", "Eduarda, Manu", "RJ", 3, 7);
            foto.setAno(2027);
            //System.out.println(foto.data());
            System.out.println(foto);

            Multimidia m= new Multimidia();

            m.setHoras(2);
            m.setMinutos(5);
            m.setSegundos(30);
            //System.out.println(m.duracao());
            System.out.println(m);


        }
    }

