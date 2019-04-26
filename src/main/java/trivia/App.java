package trivia;

import static spark.Spark.get;
import static spark.Spark.post;

import static spark.Spark.before;
import static spark.Spark.after;

import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.DB;

import trivia.User;

import com.google.gson.Gson;
import java.util.Map;

public class App
{
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

	/*map https://jarroba.com/map-en-java-con-ejemplos/
	Gson() https://stackoverflow.com/questions/31837941/gson-fromjson-throws-stackoverflowerror?noredirect=1&lq=1
		deserialization https://stackoverflow.com/questions/1360632/what-are-object-serialization-and-deserialization
	*/

      post("/users", (req, res) -> {
        Map<String, Object> bodyParams = new Gson().fromJson(req.body(), Map.class);

        User user = new User();
        user.set("username", bodyParams.get("username"));
        user.set("password", bodyParams.get("password"));
        user.saveIt();

        res.type("application/json");

        return user.toJson(true);
      });
    }
}
