package trivia;

import org.javalite.activejdbc.Model;

public class Categori extends Model {
	static{
		validatePresenceOf("nomb");
	}

	public Categori(){

	}
	
	public Categori(VARCHAR(56) nomb){
		set("Categori", nomb);
	}
	
	public int getnomb(){
		return this.get("nomb");
	}
	
	public Map getCategori(){
		Map m = new hashMap();
		m.put("id", this.get("id"));
		m.put("nomb", this.get("nomb"));
		return m;
	}
	
	public static List<Map> getTotalCategori(){
		List<Categori> cs = new  ArrayList<Categori>();
		cs=categori.findAll();
		List<Map> csgo = new ArrayList<Map>();
		for (Categori cate : cs) {
			csgo.add(cate.getCategori());
		}
		return csgo;
	}
	
	public static Categori getIdCate (int idCate){
		Categori c = Categori.findById(idCate);
		return c;
	}
	
	public static void createCategori (VARCHAR(56) nom){
		Categori cate = new Categori(nom);
		cate.saveIt();
	}
}













