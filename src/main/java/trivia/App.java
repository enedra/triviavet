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

class Questiones
{
  String ques;
  String cate;
  Boolean actv;
  ArrayList<Optiones> options;
}

class Optiones
{
  String optn;
  Boolean corr;
}

public class App
{
    static User currentUser;
    public static void main( String[] args )

  //before, req(request), res(response), after, get, post http://sparkjava.com/documentation#stopping-the-server
    {
      before((request, response) -> {
        Base.open();
      });

      after((request, response) -> {
        Base.close();
      });

      get("/hello/:name", (req, res) -> {
        return "hello" + req.params(":name");
      });

      post("/users", (req, res) -> {
        Map<String, Object> bodyParams = new Gson().fromJson(req.body(), Map.class);

        User user = new User();
        user.set("name", bodyParams.get("name"));
        user.set("pass", bodyParams.get("pass"));
        user.set("canc", bodyParams.get("canc"));
        user.set("cani", bodyParams.get("cani"));
        user.set("admi", bodyParams.get("admi"));
        user.saveIt();

        res.type("application/json");

        return user.toJson(true);
      });

      post("/questions", (req, res) -> {
        
        Questiones bodyParams = new Gson().fromJson(req.body(), Questiones.class);

        Question question = new Question();
        question.set("ques", bodyParams.ques);
        question.set("cate", bodyParams.cate);
        question.set("actv", bodyParams.actv);
        question.saveIt();


        for(Optiones item: bodyParams.options) {
          Option option = new Option();
          option.set("optn", item.optn).set("corr", item.corr);
          question.add(option);
        }
        
        res.type("application/json");
        return question.toJson(true);
      });

      //return a question whith his options
      get("/questions", (req, res) -> {
        
        Map<String, Object> bodyParams = new Gson().fromJson(req.body(), Map.class);

        Boolean noEncontrado = true;
        List<Question> question = Question.where("cate = ?", bodyParams.get("cate"));
        Question preg = new Question();

        int a = 0;
        while(noEncontrado){
          preg = question.get(a);
          if(!(Boolean)preg.get("actv")){
            noEncontrado = false;
          }
          a++;
        }
        int id = (int)preg.get("id");

        List<Option> option = Option.where("question_id = ?", id);
        List<String> lista = new ArrayList<String>();
        for(Option o: option ){
          String opcion = (String)o.get("ques");
          lista.add(opcion);
        }
        
        return preg.get("ques") + " : " + lista;
      });  

      //verify that some user is load
      get("/users", (req, res) -> {
        
        Map<String, Object> bodyParams = new Gson().fromJson(req.body(), Map.class);

        User user = User.findFirst("name = ?", bodyParams.get("name"));
        if(user == null){
          
         return "Usuario no valido"; 
        }else{
          
          return user;
        }

      });

      //modify a pass of a user with his name
      put("/users", (req,res) -> {
        
        Map<String, Object> bodyParams = new Gson().fromJson(req.body(), Map.class);

        User user = User.findFirst("name = ?", bodyParams.get("name"));
        user.set("pass", bodyParams.get("pass"));
        user.saveIt();

        res.type("application/json");
        
        return user.toJson(true);
      });

      //delete a user
      delete("/users", (req, res) -> {
        
        Map<String, Object> bodyParams = new Gson().fromJson(req.body(), Map.class);

        User user = User.findFirst("name = ?", bodyParams.get("name"));
        user.delete();
        
        return "Usuario eliminado";
      });
      
      //modify the description of a question with his id
      put("/questions", (req,res) -> {
        
        Map<String, Object> bodyParams = new Gson().fromJson(req.body(), Map.class);

        Question question = Question.findFirst("id = ?", bodyParams.get("id"));
        question.set("ques", bodyParams.get("ques"));
        question.saveIt();

        res.type("application/json");
        
        return question.toJson(true);
      });

      //delete a question
      delete("/questions", (req, res) -> {
        
        Map<String, Object> bodyParams = new Gson().fromJson(req.body(), Map.class);

        Question question = Question.findFirst("id = ?", bodyParams.get("id"));
        question.delete();
        
        return "Pregunta eliminada";
      });

      post("/games", (req, res) -> {
        
        Map<String, Object> bodyParams = new Gson().fromJson(req.body(), Map.class); 
    

        List<User> users = User.where("name = ?", bodyParams.get("name"));
        if(users.size() > 0){
          User user = users.get(0);
          String pass = (String)bodyParams.get("pass");
          if(user.get("pass").equals(pass)){
          
            Boolean noEncontrado = true;
            List<Question> question = Question.where("cate = ? and actv = ?", bodyParams.get("cate"),false);
            Question preg = new Question();

            int user_corr =(int) user.get("canc");            
            int user_incorr =(int) user.get("cani");


            int a = 0;

            while(noEncontrado){
              a++;
              preg = question.get(a);
              if(!(Boolean)preg.get("actv")){
                noEncontrado = false;
              }
            }

            preg.set("actv", true);
            preg.save();

            int id = (int)preg.get("id");

            List<Option> options = Option.where("question_id = ?", id);
            List<String> list = new ArrayList<String>();
            for(Option o: options ){
              String option = "Su descripcion es: " + o.get("optn");
              list.add(option);
            }

            List<Option> answer = Option.where("question_id = ? and corr = ?", id, true);
            Option option_corr = answer.get(0);
            if(option_corr.get("ques").equals(bodyParams.get("ques"))){
              user_corr = user_corr + 1;
              user.set("canc", user_corr);
              user.save();
              return user.toJson(true);
            }
            user_incorr = user_incorr + 1;
            user.set("cani", user_incorr);
            user.save();
            
            res.type("application/json");
            return user.toJson(true);
          }else{ 
            
            res.type("application/json");
            return user.toJson(true);
        }
      }
      
      return "";     
    });

      post("/login", (req, res) -> {
        res.type("application/json");

        return currentUser.toJson(true);
      });

    }
}
