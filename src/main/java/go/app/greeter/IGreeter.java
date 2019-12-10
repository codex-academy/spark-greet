package go.app.greeter;

import go.app.greet.Person;

import java.util.List;

public interface IGreeter {

    List<Person> greetedPeople();

    String greet(String name, String language);

    Integer getCount();
}
