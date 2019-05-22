package trivia;

import trivia.User;

import org.javalite.activejdbc.Base;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OptionTest {
  @Before
  public void before(){
      Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/trivia_dev", "root", "ojodehorus25683");
      System.out.println("OptionTest setup");
      Base.openTransaction();
  }

  @After
  public void after(){
      System.out.println("UserTest tearDown");
      Base.rollbackTransaction();
      Base.close();
  }

  @Test
  public void validatePresenceOfOption() {
	  Option option = new Option();
      option.set("optn", "enfermedad");
      option.set("corr", true);
      option.set("question_id", "1");
         
    assertEquals("username can't be blank", option.isValid(), true);
  }
}