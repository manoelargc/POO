package BancoDeMidias;

public interface ICatalogo {
    void inserir(Midia midia);
    void exibir();
    Midia consultar(String titulo);
    void editar(String titulo, Midia novaMidia);
    void excluir(String titulo);
}
