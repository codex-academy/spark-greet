package go.app.greet;

public class Greeting {
    private final String message;
    private final Integer counter;

    public Greeting(String message, Integer counter) {
        this.message = message;
        this.counter = counter;
    }

    public String getMessage() {
        return message;
    }


    public Integer getCounter() {
        return counter;
    }
}
