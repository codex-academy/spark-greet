package go.app;

import java.io.Serializable;

public class Person implements Serializable {
    private Integer id;
    private String firstName;
    private Integer counter;

    public Person(Integer id, String firstName, Integer counter) {
        this.id = id;
        this.firstName = firstName;
        this.counter = counter;
    }

    public Integer getId() {
        return id;
    }

    public Integer getCounter() {
        return counter;
    }

    public String getFirstName() {
        return firstName;
    }
}
