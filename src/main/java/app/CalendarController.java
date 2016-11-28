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

    /**
     * Devuelve una coleccion con todos los calendarios.
     * @return una coleccion de calendarios
     */
    @RequestMapping(value = "/calendars", method = RequestMethod.GET)
    public Collection<Calendar> getAllCalendars() {
        return CalendarSource.getCalendars();
    }

    /**
     * Devuelve una coleccion con los calendarios de un usuario
     * @param userId
     * @return una coleccion con los calendarios del usuario
     */
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

    /**
     * Devuelve los datos del calendario que se pasa como parámentro
     * @param userId
     * @param calendarId
     * @return un objeto de tipo Calendar
     */
    @RequestMapping(value = "/users/{userId}/calendars/{calendarId}", method = RequestMethod.GET)
    public Calendar getById(@PathVariable("userId") Long userId,
                                        @PathVariable("calendarId") Long calendarId) {
        if (CalendarSource.getCalendar(calendarId).getOwner().getId() == userId){
            return CalendarSource.getCalendar(calendarId);
        }
        return null;
    }

    /**
     * Agrega un calendario.
     * @param userId
     * @param input
     */
    @RequestMapping(value = "/users/{userId}/calendars/add", method = RequestMethod.POST)
    public void add(@PathVariable("userId") Long userId, @RequestBody Calendar input){
        CalendarSource.addCalendar(input.getName(), userId);
    }

    /**
     * Borra un calendario.
     * @param calendarId
     * @param userId
     */
    @RequestMapping(value = "/users/{userId}/calendars/{calendarId}/delete", method = RequestMethod.DELETE)
    public void delete(@PathVariable("calendarId") Long calendarId, @PathVariable("userId") Long userId){
        if (CalendarSource.getCalendar(calendarId).getOwner().getId() == userId){
            CalendarSource.deleteCalendar(calendarId);
        }
    }

    /**
     * Actualiza los datos del calendario que se pasa como parámetro
     * @param calendarId
     * @param userId
     * @param input
     */
    @RequestMapping(value = "/users/{userId}/calendars/{calendarId}/update", method = RequestMethod.PUT)
    public void update(@PathVariable("calendarId") Long calendarId, @PathVariable("userId") Long userId,
                       @RequestBody Calendar input){
        if (CalendarSource.getCalendar(calendarId).getOwner().getId() == userId){
            CalendarSource.updateCalendar(calendarId, input.getName());
        }
    }
}
