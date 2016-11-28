package app;

import java.util.ArrayList;

/**
 * Created by arcangel on 23/11/16.
 */
public class Calendar {
    private long id;
    private String name;
    private User owner;
    private ArrayList<Event> events = new ArrayList<>();

    public Calendar(long id, String name, long userId) {
        this.id = id;
        this.name = name;
        this.owner = UserSource.getUser(userId);
    }

    public Calendar(String name, long userId) {
        this.name = name;
        this.owner = UserSource.getUser(userId);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public User getOwner(){
        return owner;
    }

    public ArrayList<Event> getEvents(){
        return events;
    }
}
