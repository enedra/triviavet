
import trivia.Question;

import org.javalite.activejdbc.Base;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QuestionTest {
  @Before
  public void before(){
      Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/trivia_dev", "root", "ojodehorus25683");
      System.out.println("QuestionTest setup");
      Base.openTransaction();
  }

  @After
  public void after(){
      System.out.println("QuestionTest tearDown");
      Base.rollbackTransaction();
      Base.close();
  }

  @Test
  public void validatePresenceOfUsername() {
    Question q = new Question();
    q.set("ques","¿que tipo de virus es triquinosis?");
    q.set("cate", "patologia");
    q.set("actv",false);
    assertEquals("question can't be blank", q.isValid(), true);
  }
}