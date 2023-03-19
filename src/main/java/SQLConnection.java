import java.sql.*;

public class SQLConnection {
    public static final String URL = "jdbc:postgresql://localhost:5433/postgres";
    public static final String USER = "postgres";
    public static final String PASS = "qwerty11";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASS);
             Statement statement = connection.createStatement()){

            statement.execute("INSERT INTO guests (name, city, age) VALUES ('Luk', 'Tatuin', '24')");
            int a = statement.executeUpdate("update guests set age = 25 where name = 'Luk'");
         // отправляет 1 запрос вместо 3 разных
            statement.addBatch("INSERT INTO guests (name, city, age) VALUES ('Luk', 'Tatuin', '24')");
            statement.addBatch("INSERT INTO guests (name, city, age) VALUES ('Tom', 'House', '4')");
            statement.addBatch("INSERT INTO guests (name, city, age) VALUES ('Jerry', 'House', '2')");

            statement.executeBatch();
            statement.clearBatch();
            //ResultSet resultSet = statement.executeQuery("select * from guests");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
