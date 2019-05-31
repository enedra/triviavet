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


public class Game extends Model {

	//validatePresenceOf();
	
	private Date fech;
	
	public Game(){
	}
	
	public Game(Date day){
		set("fech", day);
	}
	
	public Date getFecha(){
		return (Date) this.get("fech");
	}
	
	public Map getGame(){
		Map g = new HashMap();
		g.put("id", this.get("id"));
		g.put("fech", this.get("fech"));
		return g;
	}
	
	public static List<Map> getTotalGame(){
		List<Game> gs = new  ArrayList<Game>();
		gs=Game.findAll();
		List<Map> gsgo = new ArrayList<Map>();
		for (Game game : gs) {
			gsgo.add(game.getGame());
		}
		return gsgo;
	}
	
	public static Game getGame(int idGame){
		Game g = Game.findById(idGame);
		return g;
	}
	
	public static void deleteGame(int idGame){
		Game g = Game.findById(idGame);
		g.delete();
	}
	
	public static void createAGame(Date fach){
		Game game = new Game(fach);
		game.saveIt();
	}

}













