package GerenciadorEstoque;

public interface IUsuarioInterface {
        void iniciar();
        void gerenciarEstoque();
        void gerenciarNotasFiscais();
        // Métodos para gerenciar estoque
        void cadastrarProduto();
        void removerProduto();
        void mostrarProduto();
        void atualizarQuantidadeTotal();
        void atualizarPreco();
        void adicionarQuantidadeProduto();
        void subtrairQuantidadeProduto();
        // Métodos para gerenciar notas fiscais
        void adicionarNotaFiscal();
        void excluirNotaFiscal();
        void mostrarNotaFiscal();
        void retornarPrecoTotalNotaFiscal();
        void adicionarItemNotaFiscal();
        void removerItemNotaFiscal();
    }

