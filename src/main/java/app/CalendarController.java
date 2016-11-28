package app;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by arcangel on 23/11/16.
 */
@RestController
public class CalendarController {

    @RequestMapping(value = "/calendars", method = RequestMethod.GET)
    public Collection<Calendar> getAllCalendars() {
        return CalendarSource.getCalendars();
    }

    @RequestMapping(value = "/users/{userId}/calendars", method = RequestMethod.GET)
    public Collection<Calendar> getCalendarByUser(@PathVariable("userId") Long userId) {
        Collection result = new ArrayList();
        for (Calendar c : CalendarSource.getCalendars()) {
            if (c.getOwner().getId() == userId){
                result.add(c);
            }
        }
        return result;
    }

    @RequestMapping(value = "/user/{userId}/calendars/{calendarId}", method = RequestMethod.GET)
    public Calendar getById(@PathVariable("userId") Long userId,
                                        @PathVariable("calendarId") Long calendarId) {
        return CalendarSource.getCalendar(calendarId);
    }

    @RequestMapping(value = "/users/{userId}/calendars/add", method = RequestMethod.POST)
    public void add(@PathVariable("userId") Long userId, @RequestBody Calendar input){
        CalendarSource.addCalendar(input.getName(), userId);
    }

    @RequestMapping("/calendar/delete")
    public void delete(){
        System.out.println("Not implemented");
    }

    @RequestMapping("/calendar/change")
    public void change(){
        System.out.println("Not implemented");
    }
}
