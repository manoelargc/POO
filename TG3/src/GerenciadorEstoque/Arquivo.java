package GerenciadorEstoque;

import java.io.*;

public class Arquivo {
    public static void gravar(Object obj, String nomeArquivo) {
        try {
            FileOutputStream fileOut = new FileOutputStream(nomeArquivo);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(obj);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static Object ler(String nomeArquivo) {
        Object obj = null;
        try {
            FileInputStream fileIn = new FileInputStream(nomeArquivo);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            obj = in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return null;
        } catch (ClassNotFoundException c) {
            System.out.println("Classe não encontrada");
            c.printStackTrace();
            return null;
        }
        return obj;
    }
}
