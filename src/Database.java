import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {

  public static final String DB_NAME = "MyDataBase";

  public static final String URL =
      "jdbc:mysql://localhost/" + DB_NAME + "?useUnicode=true&useJDBCCompliantTimezoneShift="
          + "true&useLegacyDatetimeCode=false&serverTimezone=UTC";
  public static final String DRIVER = "com.mysql.jdbc.Driver";
  public static final String USER_NAME = "root";
  public static final String PASSWORD = "pass";

  public void createDB() throws SQLException {

    Connection conn = null;
    PreparedStatement prepSt = null;

    //DATABASE
    String database = "CREATE DATABASE IF NOT EXISTS " + DB_NAME;

    //TABLE Users
    String usersString =
        "CREATE TABLE IF NOT EXISTS Users " + " (id INTEGER NOT NULL AUTO_INCREMENT, "
            + "name VARCHAR(50), surname VARCHAR(50), " + "birthday DATE, PRIMARY KEY(id))";
    //TABLE Friendships
    String friendshipsString =
        "CREATE TABLE IF NOT EXISTS Friendships " + " (userid1 INTEGER NOT NULL, "
            + "userid2 INTEGER NOT NULL, " + "timestamp TIMESTAMP)";
    //TABLE Posts
    String postsString = "CREATE TABLE IF NOT EXISTS Posts " + "(id INTEGER NOT NULL, "
        + "userId INTEGER NOT NULL, " + "text VARCHAR(40), " + "timestamp TIMESTAMP)";

    //TABLE Likes
    String likesString = "CREATE TABLE IF NOT EXISTS Likes " + "(postid INTEGER NOT NULL, "
        + "userid INTEGER NOT NULL, " + "timestamp TIMESTAMP)";

    try {
      conn = getConnection();

      prepSt = conn.prepareStatement(database);
      prepSt.executeUpdate();

      prepSt = conn.prepareStatement(usersString);
      prepSt.executeUpdate();

      prepSt = conn.prepareStatement(friendshipsString);
      prepSt.executeUpdate();

      prepSt = conn.prepareStatement(postsString);
      prepSt.executeUpdate();

      prepSt = conn.prepareStatement(likesString);
      prepSt.executeUpdate();

    } catch (
        SQLException e) {
      System.out.println("An error occurred while connecting MySQL database");
      e.printStackTrace();
    } finally {
      if (prepSt != null) {
        conn.close();
      }
      if (conn != null) {
        conn.close();
      }
    }
  }

  public void setUser(Users user) {
    String prepUsersStatement = "INSERT INTO test.users (name, surname, birthday) values (?, ?, ?)";
    try (Connection conn = getConnection()) {
      PreparedStatement preparedStatement = conn.prepareStatement(prepUsersStatement);
      preparedStatement.setString(1, user.getName());
      preparedStatement.setString(2, user.getSurname());
      preparedStatement.setString(3, user.getBirthdate());
      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void setFrienship(Friendships frienship) {
    String prepUsersStatement = "INSERT INTO test.friendships (userid1, userid2, timestamp) values (?, ?, ?)";
    try (Connection conn = getConnection()) {
      PreparedStatement preparedStatement = conn.prepareStatement(prepUsersStatement);
      preparedStatement.setInt(1, frienship.getUserid1());
      preparedStatement.setInt(2, frienship.getUserid2());
      preparedStatement.setString(3, frienship.getTimestamp());
      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private static Connection getConnection() throws SQLException {
    return DriverManager.getConnection(URL, USER_NAME, PASSWORD);
  }

}