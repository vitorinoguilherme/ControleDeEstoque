package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "";
    private static final String USER = "";
    private static final String PASSWORD = "";

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
