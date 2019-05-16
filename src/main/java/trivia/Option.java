package trivia;

import org.javalite.activejdbc.Model;

public class Option extends Model {
	static{
		validatePresenceOf("optn","question_id","corr");
	}
}
