package go.app;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }


    public static void main(String[] args) {
        staticFiles.location("/public"); // Static files

        port(getHerokuAssignedPort());

        get("/", (req, res) -> {
            return new ModelAndView(new HashMap<>(), "index.hbs");
        }, new HandlebarsTemplateEngine());

        post("/greet", (req, res) -> {

            // get form data values
            String name = req.queryParams("firstName");

            // put the values from the form for Handlebars to use
            Map<String, String> dataMap = new HashMap<>();
            dataMap.put("name", name);

            //
            return new ModelAndView(dataMap, "hello.hbs");

        }, new HandlebarsTemplateEngine());

    }
}
