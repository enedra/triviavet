package trivia;

import org.javalite.activejdbc.Model;

public class Question extends Model {
	static{
		validatePresenceOf("ques", "actv");
	}
}

	private String ques;
	private int category_id;
	private boolean actv;

	public Question() {
	}

	public Question(String ques, int category_id, boolean actv) {
		set("ques", ques);
		set("category_id", category_id);
		set("actv", actv);
	}

	public String getQues() {
		return this.get("ques");
	}

	public int getCategory_id() {
		return this.get("category_id");
	}

	public boolean getActv() {
		return this.get("actv");
	}

	public Map getQuestionMap() {
		Map question = new HashMap();
		question.put("id", this.getId());
		question.put("ques", this.getQues());
		question.put("category_id", this.getCategory_id());
		question.put("actv", this.getActv());
		return question;
	}

	public static List<Map> getAllQuestionMap() {
		List<Question> listQuestion = new ArrayList<Question>();
		listQuestion = Question.findAll();
		List<Map> allQuestionMap = new ArrayList<Map>();
		for (Question question : listQuestion) {
			allQuestionMap.Add(question.getQuestionMap());
		}
		return allQuestionMap;
	}
	
	public static Question getQuestion(int id) {
		Question question = Question.findById(id);
		return question;
	}

	public static void deleteQuestion(int id) {
		Question question = Question.findById(id);
		question.delete();
	}

	public static void createQuestion(String ques, boolean actv, int category_id) {
		Question question = new Question(ques, actv, category_id);
		question.SaveIt();
	}

//Metodos

	public static List<Map> getCategoryQuestionMap(int cate_id) {
		List<Question> listQuestion = new ArrayList<Question>();
		listQuestion = Question.findAll();
		List<Map> categoryQuestionMap = new ArrayList<Map>();
		for (Question question : listQuestion) {
			if question.getId() = cate_id {
				categoryQuestionMap.Add(question.getQuestionMap());
			}
		}
		return categoryQuestionMap;
	}
