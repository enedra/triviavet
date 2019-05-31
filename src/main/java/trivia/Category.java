package trivia;

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
import org.javalite.activejdbc.Model;

public class Category extends Model {
	static{
		validatePresenceOf("nomb");
	}

	private String nomb;

	public Category(){
	}
	
	public Category(String nomb){
		set("nomb", nomb);
	}
	
	public String getNomb(){
		return (String) this.get("nomb");
	}
	
	public Map getCategory(){
		Map m = new HashMap();
		m.put("id", this.get("id"));
		m.put("nomb", this.get("nomb"));
		return m;
	}
	
	public static List<Map> getTotalCategory(){
		List<Category> cs = new ArrayList<Category>();
		cs= Category.findAll();
		List<Map> csgo = new ArrayList<Map>();
		for (Category cate : cs) {
			csgo.add(cate.getCategory());
		}
		return csgo;
	}
	
	public static Category getCatrye (int idCate){
		Category c = Category.findById(idCate);
		return c;
	}
	
	public static void createCategory (String nom){
		Category cate = new Category(nom);
		cate.saveIt();
	}

//Metodos
}
