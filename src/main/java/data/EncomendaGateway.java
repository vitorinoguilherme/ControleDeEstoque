package data;

import models.Encomenda;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EncomendaGateway {
    Connection conn = ConnectionFactory.getConnection();

    public List<Encomenda> getAll() throws Exception {
        List<Encomenda> encomendas = new ArrayList<>();

        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM Encomenda");

        while (rs.next()) {
            Encomenda encomenda = new Encomenda(
                    rs.getInt("codigo"),
                    rs.getDouble("frete"),
                    rs.getDate("dataPedido"),
                    rs.getDate("dataEntrega"),
                    rs.getInt("codigoTransportadora"),
                    rs.getString("cnpjTransportadora")
            );

            encomendas.add(encomenda);
        }
        rs.close();

        return encomendas;
    }

    public void create() throws SQLException {

    }

    public void update() throws SQLException {

    }

    public void delete() throws SQLException {

    }
}
