package data;

import models.Fornecedor;

import java.util.List;
import java.util.ArrayList;
import java.sql.*;


public class FornecedorGateway {
    private Connection conn = ConnectionFactory.getConnection();

    public List<Fornecedor> getAll() throws SQLException {
        List<Fornecedor> fornecedores = new ArrayList<>();
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM Fornecedor;");

        while (rs.next()) {
            Fornecedor fornecedor = new Fornecedor(
                    rs.getInt("codigo"),
                    rs.getString("razaoSocial"),
                    rs.getString("cnpj"),
                    rs.getString("email"),
                    rs.getString("telefone"),
                    rs.getString("cep")
            );

            fornecedores.add(fornecedor);
        }
        rs.close();

        return fornecedores;
    }

    public void create(String razaoSocial, String cnpj, String email, String telefone, String cep) throws SQLException {
        String SQL_INSERT = "INSERT INTO Fornecedor (razaoSocial, cnpj, email, telefone, cep) VALUES (?, ?, ?, ?, ?);";

        PreparedStatement pstm = conn.prepareStatement(SQL_INSERT);

        pstm.setString(1, razaoSocial);
        pstm.setString(2, cnpj);
        pstm.setString(3, email);
        pstm.setString(4, telefone);

        pstm.execute();
        pstm.close();
    }

    // Definir o que é necessário atualizar.

    // Definir como excluir um determinado Fornecedor

}
