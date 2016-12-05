package app;

import java.util.HashMap;

/**
 * Created by arcangel on 23/11/16.
 */
public class Calendar {
    private long id;
    private String name;
    private User owner;
    private HashMap<Long, String> events = new HashMap<>();

    public Calendar(){}

    public Calendar(String name) {
        this.name = name;
    }

    public Calendar(long id, String name, long userId) {
        this.id = id;
        this.name = name;
        this.owner = UserSource.getUser(userId);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public User getOwner(){
        return owner;
    }

    public HashMap<Long, String> getEvents(){
        for (Event e : EventSource.getEvents()) {
            if (e.getOwner().getId() == this.id){
                this.events.put(e.getId(), e.getName());
            }
        }
        return events;
    }
}
