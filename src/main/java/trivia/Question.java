package trivia;

import org.javalite.activejdbc.Model;

public class Question extends Model {
	static{
		validatePresenceOf("ques","categorie_id","user_id","actv");
	}

}
