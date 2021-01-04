package data;

import models.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ProdutoGateway Class with gateway of table Produto database.
 * @version 1.0
 */
public class ProdutoGateway {
    Connection conn = ConnectionFactory.getConnection();

    /**
     * Get all products from table Produto.
     * @return list of all products.
     * @throws SQLException
     */
    public List<Produto> getAll() throws SQLException {
        List<Produto> produtos = new ArrayList<>();

        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM Produto;");

        while (rs.next()) {
            Produto produto = new Produto(
                    rs.getInt("codigo"),
                    rs.getString("nome"),
                    rs.getInt("quantidadeMinima"),
                    rs.getDate("validade"),
                    rs.getString("descricao"),
                    rs.getDouble("peso"),
                    rs.getString("cor"),
                    rs.getDouble("altura"),
                    rs.getDouble("largura"),
                    rs.getInt("codigoFornecedor"),
                    rs.getString("cnpjFornecedor"),
                    rs.getInt("codigoCategoria")
            );

            produtos.add(produto);
        }
        rs.close();

        return produtos;
    }

    /**
     * Overloaded method create a new product in the Produto table in the database with not null atribbutes.
     * @param nome
     * @param quantidadeMinima
     * @param validade
     * @param codigoFornecedor
     * @param cnpjFornecedor
     * @param codigoCategoria
     * @throws SQLException
     */
    public void create(String nome, Integer quantidadeMinima, Date validade, Integer codigoFornecedor,
                       String cnpjFornecedor, Integer codigoCategoria) throws SQLException {
        String SQL_INSERT = "INSERT INTO Produto (nome, quantidadeMinima, validade, codigoFornecedor, cnpjFornecedor," +
                " codigoCategoria) VALUES (?, ?, ?, ?, ?, ?);";

        PreparedStatement pstm = conn.prepareStatement(SQL_INSERT);

        pstm.setString(1, nome);
        pstm.setInt(2, quantidadeMinima);
        pstm.setDate(3, (java.sql.Date) validade);
        pstm.setInt(4, codigoFornecedor);
        pstm.setString(5, cnpjFornecedor);
        pstm.setInt(6, codigoCategoria);

        pstm.execute();
        pstm.close();
    }

    /**
     * Create a new product in the Produto table in the database with all atribbutes.
     * @param nome
     * @param quantidadeMinima
     * @param validade
     * @param descricao
     * @param peso
     * @param cor
     * @param altura
     * @param largura
     * @param codigoFornecedor
     * @param cnpjFornecedor
     * @param codigoCategoria
     * @throws SQLException
     */
    public void create(String nome, Integer quantidadeMinima, Date validade, String descricao, Double peso, String cor,
                       Double altura, Double largura, Integer codigoFornecedor, String cnpjFornecedor,
                       Integer codigoCategoria) throws SQLException {

        String SQL_INSERT = "INSERT INTO Produto (nome, quantidadeMinima, validade, descricao, peso, cor, altura," +
                "largura, codigoFornecedor, cnpjFornecedor, codigoCategoria) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        PreparedStatement pstm = conn.prepareStatement(SQL_INSERT);

        pstm.setString(1, nome);
        pstm.setInt(2, quantidadeMinima);
        pstm.setDate(3, (java.sql.Date) validade);
        pstm.setString(4, descricao);
        pstm.setDouble(5, peso);
        pstm.setString(6, cor);
        pstm.setDouble(7, altura);
        pstm.setDouble(8, largura);
        pstm.setInt(9, codigoFornecedor);
        pstm.setString(10, cnpjFornecedor);
        pstm.setInt(11, codigoCategoria);

        pstm.execute();
        pstm.close();
    }

    /**
     * Update atribbutes of specific product by the codigo in the Produto table.
     * @param nome
     * @param descricao
     * @param peso
     * @param cor
     * @param altura
     * @param largura
     * @throws SQLException
     */
    public void update(String nome, String descricao, Double peso, String cor,
                       Double altura, Double largura) throws SQLException {
        String SQL_UPDATE = "UPDATE Produto SET nome = ?, descricao = ?, peso = ?, cor = ? altura = ?, largura = ?" +
                "WHERE codigo = ?;";

        PreparedStatement pstm = conn.prepareStatement(SQL_UPDATE);

        pstm.setString(1, nome);
        pstm.setString(2, descricao);
        pstm.setDouble(3, peso);
        pstm.setString(4, cor);
        pstm.setDouble(5, altura);
        pstm.setDouble(6, largura);

        pstm.executeUpdate();
        pstm.close();
    }

    /**
     * Delete one specific product by the codigo in the Produto table.
     * @param codigo
     * @throws SQLException
     */
    public void delete(Integer codigo) throws SQLException {
        String SQL_DELETE = "DELETE FROM Produto WHERE codigo = ?;";

        PreparedStatement pstm = conn.prepareStatement(SQL_DELETE);

        pstm.setInt(1, codigo);

        pstm.executeUpdate();
        pstm.close();
    }

}
