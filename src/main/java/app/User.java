package app;

import java.util.ArrayList;

/**
 * Created by arcangel on 23/11/16.
 */
public class User {
    private long id;
    private String name;
    private String email;
    private ArrayList<Calendar> calendars = new ArrayList<>();

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

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail(){
        return email;
    }

    public ArrayList<Calendar> getCalendars(){
        return calendars;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setCalendars(){}
}
