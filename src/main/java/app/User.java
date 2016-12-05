package app;

import java.util.HashMap;

/**
 * Created by arcangel on 23/11/16.
 */
public class User {
    private long id;
    private String name;
    private String email;
    private HashMap<Long, String> calendars = new HashMap<>();

    public User(){}

    public User(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public User(String name, String email){
        this.name = name;
        this.email = email;
    }

    public User(String email){
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public HashMap<Long, String> getCalendars(){
        for (Calendar c : CalendarSource.getCalendars()) {
            if (c.getOwner().getId() == this.id){
                this.calendars.put(c.getId(), c.getName());
            }
        }
        return calendars;
    }
}
