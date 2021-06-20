package app.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectPostgreSQL {
    private static String url = "jdbc:postgresql://localhost:8081/postgres";
    private static String username = "postgres";
    private static String password = "postgres";
    private static Connection conn;

    public static Connection getConnection(){
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:8081/postgres", "postgres", "postgres");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
