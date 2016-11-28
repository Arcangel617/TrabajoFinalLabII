package app;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.spi.CalendarNameProvider;

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

    @RequestMapping(value = "/users/{userId}/calendars/{calendarId}", method = RequestMethod.GET)
    public Calendar getById(@PathVariable("userId") Long userId,
                                        @PathVariable("calendarId") Long calendarId) {
        if (CalendarSource.getCalendar(calendarId).getOwner().getId() == userId){
            return CalendarSource.getCalendar(calendarId);
        }
        return null;
    }

    @RequestMapping(value = "/users/{userId}/calendars/add", method = RequestMethod.POST)
    public void add(@PathVariable("userId") Long userId, @RequestBody Calendar input){
        CalendarSource.addCalendar(input.getName(), userId);
    }

    @RequestMapping(value = "/users/{userId}/calendars/{calendarId}/delete", method = RequestMethod.DELETE)
    public void delete(@PathVariable("calendarId") Long calendarId, @PathVariable("userId") Long userId){
        if (CalendarSource.getCalendar(calendarId).getOwner().getId() == userId){
            CalendarSource.deleteCalendar(calendarId);
        }
    }

    @RequestMapping(value = "/users/{userId}/calendars/{calendarId}/update", method = RequestMethod.PUT)
    public void update(@PathVariable("calendarId") Long calendarId, @PathVariable("userId") Long userId,
                       @RequestBody Calendar input){
        if (CalendarSource.getCalendar(calendarId).getOwner().getId() == userId){
            CalendarSource.updateCalendar(calendarId, input.getName());
        }
    }
}
