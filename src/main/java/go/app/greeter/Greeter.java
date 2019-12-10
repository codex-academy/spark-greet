package go.app.greeter;

import go.app.greet.Person;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Greeter extends GreeterBase implements IGreeter {
    Map<String, Integer> greetedMap = new HashMap<>();

    @Override
    public void updateCount(String name) {
        if (!greetedMap.containsKey(name)) {
            greetedMap.put(name, 0);
        }
        greetedMap.put(name, greetedMap.get(name) + 1);
    }

    @Override
    public List<Person> greetedPeople() {
        return null;
    }

    @Override
    public Integer getCount() {
        return greetedMap.keySet().size();
    }


}
