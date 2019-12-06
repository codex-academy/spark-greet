package go.app;

import java.util.HashMap;
import java.util.Map;

public class Greeter {

    Map<String, Integer> greetedMap = new HashMap<>();

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

    private void updateCount(String name) {
        if (!greetedMap.containsKey(name)) {
            greetedMap.put(name, 1);
        } else {
            greetedMap.put(name, greetedMap.get(name) + 1);
        }
    }

    public Integer getCount() {
        return greetedMap.keySet().size();
    }
}
