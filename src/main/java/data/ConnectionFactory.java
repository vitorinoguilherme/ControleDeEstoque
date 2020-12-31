package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/db_estoque?useTimezone=true&serverTimezone=UTC";
    private static final String USER = "admin";
    private static final String PASSWORD = "a5b79c5y7?";

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            Properties props = new Properties();
            props.setProperty("user", USER);
            props.setProperty("password", PASSWORD);

            Connection conn = DriverManager.getConnection(URL, props);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
