package trivia;

import org.javalite.activejdbc.Model;

public class Categori extends Model {
	static{
		validatePresenceOf("nomb");
	}

}
