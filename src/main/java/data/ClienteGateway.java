package data;

import models.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClienteGateway {
    Connection conn = ConnectionFactory.getConnection();

    public List<Cliente> getAll() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();

        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM Cliente");

        while (rs.next()) {
            Cliente cliente = new Cliente(
                    rs.getInt("codigo"),
                    rs.getString("cpf"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getDate("dataNascimento"),
                    rs.getString("cep")
            );

            clientes.add(cliente);
        }
        rs.close();

        return clientes;
    }

    public void create(String cpf, String nome, String email, Date dataNascimento, String cep) throws SQLException {
        String SQL_INSERT = "INSERT INTO Cliente (cpf, nome, email, dataNascimento, cep) VALUES (?, ?, ?, ?, ?);";

        PreparedStatement pstm = conn.prepareStatement(SQL_INSERT);

        pstm.setString(1, cpf);
        pstm.setString(2, nome);
        pstm.setString(3, email);
        pstm.setDate(4, (java.sql.Date) dataNascimento);
        pstm.setString(5, cep);

        pstm.execute();
        pstm.close();
    }

    // Denifinir o que é necessário atualizar.

    // Definir como excluir um determinado Cliente
}
