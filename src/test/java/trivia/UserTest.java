package trivia; 
import trivia.User; 
import org.javalite.activejdbc.Base; 
import org.junit.After; 
import org.junit.Before; 
import org.junit.Test; 
import static org.junit.Assert.assertEquals; 

public class UserTest{ 
	
	@BeforeClasspublic voidbefore(){         
		Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/trivia", "pass", "pass");         
		System.out.println("UserTest setup");         
		Base.openTransaction();     
	} 

	@AfterClasspublic voidafter(){         
		System.out.println("UserTest tearDown");         
		Base.rollbackTransaction();         
		Base.close();     
	} 

	@Testpublic voidvalidateUniquenessOfUsernames(){         
		User user = newUser();         
		user.set("username", ""); 
		assertEquals(user.isValid(), false);     
	}
}