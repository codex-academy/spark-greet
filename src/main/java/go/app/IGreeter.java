package go.app;

import java.util.List;

public interface IGreeter {

    List<Person> greetedPeople();

    String greet(String name, String language);

    Integer getCount();
}
