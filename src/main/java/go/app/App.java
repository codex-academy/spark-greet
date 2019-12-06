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
            String language = req.queryParams("language");

            String greeting = "Invalid language";

            if (language.equals("afr")) {
                greeting = "Goeie dag, " + name;
            } else if ("eng".equals(language)) {
                greeting = "Good day, " + name;
            } else if ("xhosa".equals(language)) {
                greeting = "Molo, " + name;
            }


            // put the values from the form for Handlebars to use
            Map<String, String> dataMap = new HashMap<>();
            dataMap.put("greeting", greeting);

            //
            return new ModelAndView(dataMap, "hello.hbs");

        }, new HandlebarsTemplateEngine());

    }
}
