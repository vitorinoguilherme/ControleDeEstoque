package data;

import models.Categoria;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class CategoriaGateway {
    Connection conn = ConnectionFactory.getConnection();

    public List<Categoria> getAll() throws SQLException {
        List<Categoria> categorias = new ArrayList<>();

        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM Categoria;");

        while (rs.next()) {
            Categoria categoria = new Categoria(
                    rs.getInt("codigo"),
                    rs.getString("nome")
            );

            categorias.add(categoria);
        }
        rs.close();

        return categorias;
    }

    public void create(String nome) throws SQLException {
        String SQL_INSERT = "INSERT INTO Categoria (nome) VALUES (?);";

        PreparedStatement pstm = conn.prepareStatement(SQL_INSERT);

        pstm.setString(1, nome);

        pstm.execute();
        pstm.close();
    }

    public void update(Integer codigo, String nome) throws SQLException {
        String SQL_UPDATE = "UPDATE Categoria SET nome = ? WHERE codigo = ?;";

        PreparedStatement pstm = conn.prepareStatement(SQL_UPDATE);

        pstm.setString(1, nome);
        pstm.setInt(2, codigo);

        pstm.executeUpdate();
        pstm.close();
    }

    public void delete(Integer codigo) throws SQLException {
        String SQL_DELETE = "DELETE FROM Categoria WHERE codigo = ?;";

        PreparedStatement pstm = conn.prepareStatement(SQL_DELETE);

        pstm.setInt(1, codigo);

        pstm.executeUpdate();
        pstm.close();
    }

}
