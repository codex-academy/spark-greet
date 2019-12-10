package go.app.greeter;

public abstract class GreeterBase implements IGreeter {

    @Override
    public String greet(String name, String language) {
        String greeting = "Invalid language";
        if (language.equals("afr")) {
            greeting = "Goeie dag, " + name;
        } else if ("eng".equals(language)) {
            greeting = "Good day, " + name;
        } else if ("xhosa".equals(language)) {
            greeting = "Molo, " + name;
        }

        if (!greeting.equals("Invalid language")) {
            updateCount(name);
        }

        return greeting;
    }

    public abstract void updateCount(String name);


}
