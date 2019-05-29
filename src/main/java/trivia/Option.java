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


public class Option extends Model {
	static{
		validatePresenceOf("optn");
	}

	private String optn;
	private boolean corr;
	private int question_id;
	
	public Option(){
	}

	public Option(String optn, boolean corr, int question_id){
		int lenghtQuestionOption = lenght(getQuestionOptionMap(question_id));
		if (!(corr && oneOptionTrue(question_id)) && (lenghtQuestionOption < 4)) { //comprobar si esta bien
			if ((lenghtQuestionOption < 3) || ((lenghtQuestionOption == 3) && (corr != oneOptionTrue(question_id)))) {
				set("optn", optn);
				set("corr", corr);
				set("question_id", question_id);
			}
		}
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
	    option.put("corr",this.getCorr());
	    option.put("question_id", this.getQuestion_id());
		return option;
	}

	public static List<Map> getQuestionOptionMap(int ques_id) {
		List<Option> allOption = new ArrayList<Option>();
		allOption = Option.findAll();
		List<Map> questionOptionMap = new ArrayList<Map>();
		for (Option option : allOption) {
			if (option.getId() = ques_id) {
				questionOptionMap.add(option.getOptionMap());
			}
		}
		return questionOptionMap;
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
		option.saveIt();
	}

	public boolean oneOptionTrue (int ques_id) {
		List<Map> optionQuestioMap = new ArrayList<Map>();
		questionOptionMap = getQuestionOptionMap(ques_id);
		for (Option option : questionOption) { 
			if (option.getCorr()) {
				return true;
			}
		}
		return false;
	}

//Metodos
}