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
		u.put("id", this.(getId)());
		u.put("mane", this.(getName()));
		u.put("pass", this.(getPass()));
		u.put("admi", this.(getAdmi()));
		u.put("canc", this.(getCanc()));
		u.put("cani", this.(getCani()));
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