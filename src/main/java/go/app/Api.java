package go.app;

import com.google.gson.Gson;
import go.app.greet.GreetParams;
import go.app.greet.Greeting;
import go.app.greeter.IGreeter;
import spark.Route;

public class Api {
    private IGreeter greeter;

    public Api(IGreeter greeter) {
        this.greeter = greeter;
    }

    Route greetUser () {
        return (req, res) -> {
            res.type("application/json");

             GreetParams greetParams = new Gson()
                     .fromJson(req.body(), GreetParams.class);

            String greeting = greeter.greet(
                    greetParams.getFirstName(),
                    greetParams.getLanguage());

            Integer userCount = greeter.getCount();

            return new Greeting(greeting, userCount);
        };
    }

    Route greetedUsers () {
        return (req, res) -> greeter.greetedPeople();
    }



}
