import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        SQLConnection db = new SQLConnection();
        ArrayList<Guest> guests = new ArrayList<>();

        try (Statement statement = db.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM guests ORDER BY id ");
            while (resultSet.next()){
             guests.add(new Guest(resultSet.getInt(1)
                       ,resultSet.getString(2)
               , resultSet.getString(3)
               , resultSet.getInt(4)
               , resultSet.getInt(5)));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        guests.forEach(System.out::println);
    }







}
