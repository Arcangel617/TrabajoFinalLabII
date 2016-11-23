package app;

/**
 * Created by arcangel on 23/11/16.
 */
public class Event {
    private final long id;
    private  String name;

    public Event(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
