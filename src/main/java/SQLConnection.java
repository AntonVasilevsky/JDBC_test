import java.sql.*;

public class SQLConnection {
    private static final String URL = "jdbc:postgresql://localhost:5433/postgres";
    private static final String USER = "postgres";
    private static final String PASS = "qwerty11";

    private Connection connection;

    public SQLConnection() {
        try {
            this.connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection(){
        return connection;
    }

    public void closeConnection(){
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASS);
             Statement statement = connection.createStatement()){

            statement.execute("INSERT INTO guests (name, city, age) VALUES ('Luk', 'Tatuin', '24')");
            int a = statement.executeUpdate("update guests set age = 25 where name = 'Luk'");
         // sends 1 request instead of 3
            statement.addBatch("INSERT INTO guests (name, city, age) VALUES ('Luk', 'Tatuin', '24')");
            statement.addBatch("INSERT INTO guests (name, city, age) VALUES ('Tom', 'House', '4')");
            statement.addBatch("INSERT INTO guests (name, city, age) VALUES ('Jerry', 'House', '2')");

            statement.executeBatch();
            statement.clearBatch();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
