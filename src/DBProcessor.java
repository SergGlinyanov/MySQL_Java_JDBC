import java.sql.SQLException;
import java.util.Random;

public class DBProcessor {

  //Global variable
  Database database;

  public static void main(String[] args) throws SQLException {
    long start, end, result;
    start = System.nanoTime();

    DBProcessor dbProcessor = new DBProcessor();
    dbProcessor.startApp();

    end = System.nanoTime();
    result = (end - start)/1000000000;
    System.out.println("Время работы программы " + result + " секунд.");
  }

  public void startApp() throws SQLException {

    database = new Database();
    database.createDB();

    generatedDate();
    generateUsersData();
    generateFriendshipsData();

  }

  public String generatedDate() {
    Random random = new Random();
    String[] arrDay = new String[30];
    arrDay[0] = "01";
    arrDay[1] = "02";
    arrDay[2] = "03";
    arrDay[3] = "04";
    arrDay[4] = "05";
    arrDay[5] = "06";
    arrDay[6] = "07";
    arrDay[7] = "08";
    arrDay[8] = "09";

    for (int i = 9; i < 30; i++) {
      String s = "" + i;
      arrDay[i] = s;
    }
    String[] arrMonth = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11",
        "12"};//12
    String[] arrYear = {"1977", "1978", "1983", "1984", "1988", "1989", "1990", "1992", "1997",
        "1999", "2001", "2003", "2011", "2019"};//14
    String randomMonth = arrMonth[random.nextInt(12)];
    String randomDay = arrDay[random.nextInt(30)];

    if (randomMonth.equals("02")) {
      randomDay = arrDay[random.nextInt(28)];
    }
    String date = arrYear[random.nextInt(14)] + "-" + randomMonth + "-" + randomDay;
    return date;
  }


  public void generateUsersData() {
    Random random = new Random();
    String[] arrName = {"Rob", "Bob", "Peet", "Jack", "Sara",
        "Salli", "Bill", "Kate", "Lola", "Tor", "Mike", "Bred", "Donald", "Monika", "Glen", "Ella",
        "Eva", "Isabel", "Lily", "Hugo", "Jacob", "Leo", "Oscar", "Tommy", "Gabriel"};//25
    String[] arrSurname = {"Arnold", "Austin", "Becker", "Bishop", "Bradberry", "Campbell", "Smith",
        "Gilbert", "Harrison", "Johnson", "Williams", "Jones", "Brown", "Davis",
        "Miller", "Wilson", "Moore", "Taylor", "Anderson", "Thomas", "Jackson", "White",
        "Harris", "Clark", "Cooper", "Evans", "Ford", "Bell", "Nevill", "Porter", "Salomon",
        "Sherlock", "Wayne"};//33

    int numberOfUsers = 1000;

    Users user = new Users();
    for (int i = 0; i < numberOfUsers; i++) {
      user.setName(arrName[random.nextInt(25)]);
      user.setSurname(arrSurname[random.nextInt(33)]);
      user.setBirthdate(generatedDate());
      database.setUser(user);
    }
  }

  public String generateTimeStamp() {
    Random random = new Random();
    String[] hour = new String[24];
    String[] min = new String[60];
    String[] sec = new String[60];
    for (int i = 0; i < 24; i++) {
      String s = "" + i;
      hour[i] = s;
    }
    for (int i = 0; i < 60; i++) {
      String s = "" + i;
      min[i] = s;
      sec[i] = s;
    }
    String randomMin = hour[random.nextInt(23)];
    String randomSec = min[random.nextInt(59)];
    String randomMiliSec = sec[random.nextInt(59)];
    String timeStamp = generatedDate() + " " + randomMin + ":" + randomSec + ":" + randomMiliSec;
    return timeStamp;
  }

  public void generateFriendshipsData() {
    int numberOfRows = 10000;
    Random random = new Random();
    Friendships friendship = new Friendships();

    for (int i = 0; i < numberOfRows; i++) {
      int num1 = random.nextInt(1000);
      int num2 = random.nextInt(1000);

      if (num1 != num2) {
        friendship.setUserid1(num1);
        friendship.setUserid2(num2);
      } else {
        continue;
      }
      friendship.setTimestamp(generateTimeStamp());
      database.setFrienship(friendship);
    }
  }

  public void generatePostsData() {
  }

  public void generateLikesData() {
  }


}