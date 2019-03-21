import java.sql.Timestamp;

public class Friendships {

  private int userid1;
  private int userid2;
  private String timestamp;

  public int getUserid1() {
    return userid1;
  }

  public void setUserid1(int userid1) {
    this.userid1 = userid1;
  }

  public int getUserid2() {
    return userid2;
  }

  public void setUserid2(int userid2) {
    this.userid2 = userid2;
  }

  public String getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }
}
