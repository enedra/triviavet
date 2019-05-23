package trivia;

import org.javalite.activejdbc.Model;

public class User extends Model {
	static{
		validatePresenceOf("name", "pass");//name = username
	}

	private String name;
    private String pass;
    private boolean admi;
    private int canc;
    private int cani;

    public User(){

    }

    public User(String username, String password, boolean admin){
    	set("name", username);
    	set("pass", pasword);
    	set("admi", admin);
    	set("canc", 0);
    	set("cani", 0);
    }

    public String getName() {
        return this.getString("name");
    }

    public String getPass() {
        return this.getString("pass");
    }

    public int getAdmin() {
        return this.getInteger("admi");
	}



}