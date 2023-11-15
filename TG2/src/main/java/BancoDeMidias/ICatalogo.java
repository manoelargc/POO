package BancoDeMidias;

public interface ICatalogo {
    public void carregaDados(String path);
    void insere(Midia midia);
    void mostra();
    Midia consultaPorTitulo(String titulo);
    void editar(String titulo, String Campo, String novoValor);
    void delete(String titulo);
}
