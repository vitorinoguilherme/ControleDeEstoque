package models;

/**
 * ItemSaida model class with abstract a product.
 */
public class ItemSaida {
    private Produto produto;
    private Pedido pedido;
    private Integer quantidade;

    public ItemSaida(Produto produto, Pedido pedido, Integer quantidade) {
        this.setProduto(produto);
        this.setPedido(pedido);
        this.setQuantidade(quantidade);
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getQuantidade() {
        return quantidade;
    }
}
