package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Encomenda class model.
 * This class represents an order for a new product for the store.
 */
public class Encomenda {
    private Integer codigo;
    private Double frete;
    private Date dataPedido;
    private Date dataEntrega;
    private Transportadora transportadora;
    private List<ItemEntrada> items;

    /**
     * This constructor is used by class EncomendaGateway.
     * @param codigo
     * @param frete
     * @param dataPedido
     * @param dataEntrega
     * @param codTransportadora
     * @param cnpjTransportadora
     */
    public Encomenda(Integer codigo, Double frete, Date dataPedido, Date dataEntrega,
                     Integer codTransportadora, String cnpjTransportadora) {
        this.setCodigo(codigo);
        this.setFrete(frete);
        this.setDataPedido(dataPedido);
        this.setDataEntrega(dataEntrega);
        this.transportadora = transportadora;
        this.items = new ArrayList<>();
    }

    public Encomenda() {

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

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setTransportadora(Transportadora transportadora) {
        this.transportadora = transportadora;
    }

    public Transportadora getTransportadora() {
        return transportadora;
    }
}
