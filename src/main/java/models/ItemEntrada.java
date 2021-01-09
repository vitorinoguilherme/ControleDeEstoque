package models;

/**
 * ItemEntrada class model.
 * Reference to multiples products, their quantities and order data.
 */
public class ItemEntrada {
    private Produto produto;
    private Encomenda encomenda;
    private Integer quantidade;

    public ItemEntrada(Produto produto, Encomenda encomenda, Integer quantidade) {
        this.setProduto(produto);
        this.setEncomenda(encomenda);
        this.setQuantidade(quantidade);
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setEncomenda(Encomenda encomenda) {
        this.encomenda = encomenda;
    }

    public Encomenda getEncomenda() {
        return encomenda;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getQuantidade() {
        return quantidade;
    }
}
