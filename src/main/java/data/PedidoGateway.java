package data;

import models.Pedido;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PedidoGateway {
    Connection conn = ConnectionFactory.getConnection();

    public List<Pedido> getAll() throws SQLException {
        List<Pedido> pedidos = new ArrayList<>();

        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM Pedido;");

        while (rs.next()) {
            Pedido pedido = new Pedido(
                    rs.getInt("codigo"),
                    rs.getDouble("frete"),
                    rs.getDate("dataCompra"),
                    rs.getDate("dataEntrega"),
                    rs.getInt("codigoCliente"),
                    rs.getInt("codigoTransportadora"),
                    rs.getString("cnpjTransportadora")
            );

            pedidos.add(pedido);
        }
        rs.close();

        return pedidos;
    }

    public void create() throws SQLException {

    }

    public void update() throws SQLException {

    }

    public void delete() throws SQLException {

    }
}
