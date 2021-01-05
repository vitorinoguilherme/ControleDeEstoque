package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Pedido model class.
 * reference an order placed by the customer.
 */
public class Pedido {
    private Integer codigo;
    private Double frete;
    private Date dataCompra;
    private Date dataEntrega;
    private Cliente cliente;
    private Transportadora transportadora;
    private List<ItemSaida> items;

    /**
     * This constructor is used by class PedidoGateway.
     *
     * @param codigo
     * @param frete
     * @param dataCompra
     * @param dataEntrega
     * @param codigo_cliente
     * @param codTransportadora
     * @param cnpjTransportadora
     */
    public Pedido(Integer codigo, Double frete, Date dataCompra, Date dataEntrega, Integer codigo_cliente,
                  Integer codTransportadora, String cnpjTransportadora) {
        this.setCodigo(codigo);
        this.setFrete(frete);
        this.setDataCompra(dataCompra);
        this.setDataEntrega(dataEntrega);
        this.cliente = new Cliente(codigo_cliente);
        this.transportadora = new Transportadora(codTransportadora, cnpjTransportadora);
        this.items = new ArrayList<>();
    }

    public Pedido(Integer codigo, Double frete, Date dataCompra, Date dataEntrega, Cliente cliente,
                  Transportadora transportadora) {
        this.setCodigo(codigo);
        this.setFrete(frete);
        this.setDataCompra(dataCompra);
        this.setDataEntrega(dataEntrega);
        this.cliente = cliente;
        this.transportadora = transportadora;
        this.items = new ArrayList<>();
    }

    public Pedido() {

    }

    public void addItems(ItemSaida item) {
        this.items.add(item);
    }

    public List<ItemSaida> getItems() {
        return items;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setFrete(Double frete) {
        this.frete = frete;
    }

    public Double getFrete() {
        return frete;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setTransportadora(Transportadora transportadora) {
        this.transportadora = transportadora;
    }

    public Transportadora getTransportadora() {
        return transportadora;
    }
}
