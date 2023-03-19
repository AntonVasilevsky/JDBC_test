import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {

    private static SQLConnection db = new SQLConnection();
    public static void main(String[] args) {

        ArrayList<Guest> guests = new ArrayList<>();
        guests.add(new Guest("Ann", "Lviv", 2, 22));
        guests.add(new Guest("Tarik", "Lviv", 1, 39));
        guests.add(new Guest("Ela", "Kyiv", 2, 28));

        fromListToDb(guests);

        dynamicQueryGuests();

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
        db.closeConnection();
    }

    public static void dynamicQueryGuests(){
        try (PreparedStatement preparedStatement = db.getConnection()
                .prepareStatement("INSERT INTO guests (name, city, age) VALUES (?, ?, ?);")) {
            preparedStatement.setString(1, "Dredd");
            preparedStatement.setString(2, "San-Angeles");
            preparedStatement.setInt(3, 35);

            preparedStatement.addBatch();

            preparedStatement.setString(1, "Alice");
            preparedStatement.setString(2, "Wonderland");
            preparedStatement.setInt(3, 20);

            preparedStatement.addBatch();

            preparedStatement.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void fromListToDb(ArrayList<Guest> guests){
        try (PreparedStatement preparedStatement = db.getConnection()
                .prepareStatement("INSERT INTO guests (name, city, age) VALUES (?, ?, ?);")) {
           guests.forEach(guest -> {
               try {
                   preparedStatement.setString(1, guest.getName());
                   preparedStatement.setString(2, guest.getCity());
                   preparedStatement.setInt(3, guest.getAge());

                   preparedStatement.addBatch();
               } catch (SQLException e) {
                   throw new RuntimeException(e);
               }

           });



            preparedStatement.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }







}
