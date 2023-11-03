package LocadoraVeiculos;

import java.util.ArrayList;

public class Locadora implements IVeiculo {

    public ArrayList<Veiculo> listaVeiculos;


    //metodos especiais

    //construtor
    public void Locadora() {
        listaVeiculos = new ArrayList<>();
    }

    //get e set


    //metodos abstratos

    @Override
    public void inclui(Veiculo v) {
        listaVeiculos.add(v);
    }

    @Override
    public Veiculo get(String placa) {
        for (int i = 0; i < listaVeiculos.size(); i++) {
            if (listaVeiculos.get(i).getPlaca().equalsIgnoreCase(placa)) {
                return listaVeiculos.get(i);
            }
        }
        return null;
    }

    @Override
    public boolean remove(String placa) {

        int indice = -1;

        Veiculo v = get(placa);
/*
        if (v != null) {
            listaVeiculos.remove(v);
            return true;
        } else {
            return false;

*/

        for (int i = 0; i < listaVeiculos.size(); i++) {
            if (listaVeiculos.get(i).getPlaca().equalsIgnoreCase(v.getPlaca())) {
                indice = i;
            }

            if (indice != -1) {
                listaVeiculos.remove(indice);
                return true;
            }
        }
        return false;
    }

}


