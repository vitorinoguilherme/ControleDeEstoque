
import data.FornecedorGateway;
import models.Fornecedor;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        FornecedorGateway fg = new FornecedorGateway();

        for (Fornecedor fornecedor : fg.getAll()) {
            System.out.println(fornecedor);
        }
    }
}
