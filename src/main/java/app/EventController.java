package app;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by arcangel on 23/11/16.
 */
@RestController
public class EventController {

    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public Collection<Event> getAllEvents() {
        return EventSource.getEvents();
    }

    @RequestMapping(value = "/users/{userId}/calendars/{calendarId}/events", method = RequestMethod.GET)
    public Collection<Calendar> getEventsByCalendar(@PathVariable("userId") Long userId,
                                                    @PathVariable("calendarId") Long calendarId) {
        Collection result = new ArrayList();
        for (Event e : EventSource.getEvents()) {
            if (e.getOwner().getId() == calendarId){
                result.add(e);
            }
        }
        return result;
    }

    @RequestMapping("/event/add")
    public void add(){
        System.out.println("Not implemented");
    }

    @RequestMapping("/event/delete")
    public void delete(){
        System.out.println("Not implemented");
    }

    @RequestMapping("/event/change")
    public void change(){
        System.out.println("Not implemented");
    }
}
