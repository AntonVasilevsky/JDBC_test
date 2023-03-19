import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection {
    public static final String URL = "jdbc:postgresql://localhost:5433/postgres";
    public static final String USER = "postgres";
    public static final String PASS = "qwerty11";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASS)){



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
