package LocadoraVeiculos;

public interface IVeiculo {

    public abstract void inclui(Veiculo v);
    public abstract Veiculo get(String placa);
    public abstract boolean remove(String placa);
}
