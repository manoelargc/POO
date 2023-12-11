package GerenciadorEstoque;

    /**
     * Interface para a interação do usuário.
     * Esta interface define os métodos necessários para a interação do usuário com o sistema de estoque e notas fiscais.
     *
     * @author Manoela Resende
     * @author Eduarda Sifuentes
     */
public interface IUsuarioInterface {

        /**
         * Inicia a interação do usuário
         */
        void iniciar();

        /**
         * Gerencia as operações de estoque.
         */
        void gerenciarEstoque();

        /**
         * Gerencia as operações de notas fiscais.
         */
        void gerenciarNFe();

        // Métodos para gerenciar estoque

        /**
         * Cadastra um novo produto no estoque.
         */
        void cadastrarProduto();

        /**
         * Remove um produto do estoque.
         */
        void removerProduto();

        /**
         * Mostra os detalhes de um produto.
         */
        void mostrarProduto();

        /**
         * Atualiza a quantidade total de um produto no estoque.
         */
        void atualizarQtdTotal();

        /**
         * Atualiza o preço de um produto.
         */
        void atualizarPreco();

        /**
         * Adiciona uma quantidade de um produto ao estoque.
         */
        void addQtdProduto();

        /**
         * Subtrai uma quantidade de um produto do estoque.
         */
        void subtrairQtdProduto();

        // Métodos para gerenciar notas fiscais

        /**
         * Adiciona uma nova nota fiscal.
         */
        void addNFe();

        /**
         * Exclui uma nota fiscal.
         */
        void excluirNFe();

        /**
         * Mostra os detalhes de uma nota fiscal.
         */
        void mostrarNFe();

        /**
         * Retorna o preço total de uma nota fiscal.
         */
        void retornarPrecoTotalNFe();

        /**
         * Adiciona um item a uma nota fiscal.
         */
        void addItemNFe();

        /**
         * Remove um item de uma nota fiscal.
         */
        void removerItemNFe();
    }
