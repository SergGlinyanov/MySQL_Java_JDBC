import java.sql.Timestamp;

public class Likes {
  private int postid;
  private int userid;
  private String timestamp;

  public int getPostid() {
    return postid;
  }

  public void setPostid(int postid) {
    this.postid = postid;
  }

  public int getUserid() {
    return userid;
  }

  public void setUserid(int userid) {
    this.userid = userid;
  }

  public String getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }



}
