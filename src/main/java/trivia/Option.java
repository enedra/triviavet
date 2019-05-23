package trivia;

import java.util.Map;
import java.util.Hashmap;
import org.javalite.activejdbc.Model;

public class Option extends Model {
	static{
		validatePresenceOf("optn");
	}
}

	private String optn;
	private boolean corr;
	private int question_id;
	
	public Option(){
	}

	public Option(String optn, boolean corr, int question_id){
		set("optn", optn);
		set("corr", corr);
		set("question_id", question_id);
	}

	public String getOptn() {
	        return this.get("optn");
	}

	public boolean getCorr() {
	        return this.get("corr");
	}

	public int getQuestion_id() {
	        return this.get("question_id");
	}

	public Map getOptionMap() {
	        Map option = new HashMap();
		option.put("id", this.getId());
		option.put("optn", this.getOptn());
	        option.put("corr",this.getcorr());
	        option.put("question_id", this.getQuestion_id());
		return option;
	}

	public static List<Map> getAllOptionMap() {
		List<Option> listOption = new ArrayList<Option>();
		listOption = Option.findAll();
		List<Map> listMap = new ArrayList<Map>();
		for (Option option : listMap) {
			listMap.add(option.getOption());
		}
	}

	public static Option getOption(int id) {
		Option option = Option.findById(id);
		return option;
	}

	public static void deleteOption(int id) {
		Option option = Option.findById(id);
		option.delete();
	}

	public static void createOption(String optn, boolean corr, int question_id) {
		Option option = new Option(optn, corr, question_id);
		option.SabeIt();
	}

}
