package trivia;

import org.javalite.activejdbc.Model;

public class Category extends Model {
	static{
		validatePresenceOf("nomb");
	}

	private String nomb;

	public Category(){
	}
	
	public Category(VARCHAR(56) nomb){
		set("nomb", nomb);
	}
	
	public int getNomb(){
		return this.get("nomb");
	}
	
	public Map getCategory(){
		Map m = new hashMap();
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
	
	public static void createCategory (VARCHAR(56) nom){
		Category cate = new Category(nom);
		cate.saveIt();
	}

//Metodos
