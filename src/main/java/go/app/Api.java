package go.app;

import spark.Route;

public class Api {
    private IGreeter greeter;

    public Api(IGreeter greeter) {
        this.greeter = greeter;
    }

    Route greetUser () {
        return (req, res) -> {
            String firstName = req.queryParams("firstName");
            String language = req.queryParams("language");
            String greeting = greeter.greet(firstName, language);
            return new Greeting(greeting);
        };
    }

    Route greetedUsers () {
        return (req, res) -> greeter.greetedPeople();
    }



}
