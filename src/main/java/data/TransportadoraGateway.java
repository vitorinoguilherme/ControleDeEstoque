package data;

import models.Transportadora;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransportadoraGateway {
    Connection conn = ConnectionFactory.getConnection();

    public List<Transportadora> getAll() throws SQLException {
        List<Transportadora> transportadoras = new ArrayList<>();

        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM Transportadora;");

        while (rs.next()) {
            Transportadora transportadora = new Transportadora(
                    rs.getInt("codigo"),
                    rs.getString("cnpj"),
                    rs.getString("razaoSocial"),
                    rs.getString("cep"),
                    rs.getString("telefone"),
                    rs.getString("email")
            );

            transportadoras.add(transportadora);
        }
        rs.close();

        return transportadoras;
    }

    public void create() throws SQLException {

    }

    public void update() throws SQLException {

    }

    public void delete() throws SQLException {

    }

}
