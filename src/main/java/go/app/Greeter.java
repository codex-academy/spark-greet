package go.app;

import java.util.HashMap;
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
    public Integer getCount() {
        return greetedMap.keySet().size();
    }
}
