package app;

import java.util.ArrayList;

/**
 * Created by arcangel on 23/11/16.
 */
public class Calendar {
    private final long id;
    private String name;
    private ArrayList<Event> events = new ArrayList<>();

    public Calendar(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Event> getEvents(){
        return events;
    }
}
