package trivia;

import org.javalite.activejdbc.Model;

public class Game extends Model {

	//validatePresenceOf();
	
	private Date fech;
	
	public Game(){
	}
	
	public Game(Date day){
		set("fech", day);
	}
	
	public Date getFecha(){
		return this.get("fech");
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
	
	public static void createAGame(Data fach){
		Game game = new Game(fach);
		game.saveIt();
	}

}













