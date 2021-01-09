package data;


import models.SubCategoria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubCategoriaGateway {
    Connection conn = ConnectionFactory.getConnection();

    public List<SubCategoria> getAll() throws SQLException {
        List<SubCategoria> subCategorias = new ArrayList<>();

        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM SubCategoria;");

        while (rs.next()) {
            SubCategoria subCategoria = new SubCategoria(
                    rs.getInt("codigo"),
                    rs.getString("nome"),
                    rs.getInt("codigoCategoria")
            );

            subCategorias.add(subCategoria);
        }
        rs.close();

        return subCategorias;
    }

    public void create(String nome, Integer codigoCategoria) throws SQLException {
        String SQL_INSERT = "INSERT INTO SubCategoria (nome, codigoCategoria) VALUES (?, ?);";

        PreparedStatement pstm = conn.prepareStatement(SQL_INSERT);

        pstm.setString(1, nome);
        pstm.setInt(2, codigoCategoria);

        pstm.execute();
        pstm.close();
    }

    public void update(Integer codigo, Integer codigoCategoria, String nome) throws SQLException {
        String SQL_UPDATE = "UPDATE SubCategoria SET nome = ? WHERE codigo = ? AND codigoCategoria = ?;";

        PreparedStatement pstm = conn.prepareStatement(SQL_UPDATE);

        pstm.setString(1, nome);
        pstm.setInt(2, codigo);
        pstm.setInt(3, codigoCategoria);

        pstm.executeUpdate();
        pstm.close();
    }

    public void delete(Integer codigo, Integer codigoCategoria) throws SQLException {
        String SQL_DELETE = "DELETE FROM SubCategoria WHERE codigo = ? AND codigoCategoria = ?;";

        PreparedStatement pstm = conn.prepareStatement(SQL_DELETE);

        pstm.setInt(1, codigo);
        pstm.setInt(2, codigoCategoria);

        pstm.executeUpdate();
        pstm.close();
    }
}
