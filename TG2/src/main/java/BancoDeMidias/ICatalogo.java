package BancoDeMidias;

public interface ICatalogo {
    void insere(Midia midia);
    void mostra();
    Midia consulta(String titulo);
    void editar(String titulo, Midia novaMidia);
    void delete(String titulo);
}
//nao misturar a classe
//interface exclusiva estr dados
