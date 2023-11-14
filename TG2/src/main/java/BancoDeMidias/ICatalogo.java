package BancoDeMidias;

public interface ICatalogo {
    void insere(Midia midia);
    void mostra();
    Midia consultaPorTitulo(String titulo);
    void editar(String titulo, Midia novaMidia);
    void delete(String titulo);
}
