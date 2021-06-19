package app.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectPostgreSQL {
    private static String url = "jdbc:postgresql://localhost:8081/postgres";
    private static String username = "postgres";
    private static String password = "57Gfhjkm57";
    private static Connection conn;

    public static Connection getConnection(){
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void main(String[] args) throws SQLException {
        Connection connect = ConnectPostgreSQL.getConnection();
        System.out.println(connect.getMetaData());
    }
}
