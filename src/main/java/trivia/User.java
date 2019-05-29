package trivia;

import org.javalite.activejdbc.Model;
import static spark.Spark.get;
import static spark.Spark.post;

import static spark.Spark.before;
import static spark.Spark.after;
import static spark.Spark.*;

import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.DB;

import trivia.User;
import trivia.Question;
import trivia.Option;

import com.google.gson.Gson;
import java.util.*;

import com.google.gson.Gson;

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
    	set("pass", password);
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

	public User getUser(int id){
		User u = User.findById(id);
		return u;
	}

	public void deleteUser(int id){
		User u = User.findById(id);
		u.delete();
	}

	public void createUser(String username, String password, boolean admin){
		User user = new User(username, password, admin);
		user.saveIt();
	}

	public Map getAllUser(){
		Map u = new HashMap();
		u.put("id", this.get("id"));
		u.put("mane", this.get("name"));
		u.put("pass", this.get("pass"));
		u.put("admi", this.get("admi"));
		u.put("canc", this.get("canc"));
		u.put("cani", this.get("cani"));
		return u;
	}

	public Map getAllUsers(){
		List<User> u = new ArrayList<User>();
        u = User.findAll();
        List<Map> us = new ArrayList<Map>();
        for (User user : u) {
            us.add(user.getAllUser());
        }
		return us;
	}

}