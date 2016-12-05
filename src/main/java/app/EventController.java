package app;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by arcangel on 23/11/16.
 */
@RestController
public class EventController {

    /**
     * Devuelve una coleccion con todos los eventos creados
     * @return una coleccion de eventos
     */
    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public Collection<Event> getAllEvents() {
        return EventSource.getEvents();
    }

    /**
     * Devuelve una coleccion con los eventos de un calendario
     * @param userId
     * @param calendarId
     * @return una coleccion con los calendarios del usuario
     */
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

    @RequestMapping(value = "/users/{userId}/calendars/{calendarId}/events/{eventId}", method = RequestMethod.GET)
    public Event getEventsById(@PathVariable("userId") Long userId,
                                                    @PathVariable("calendarId") Long calendarId,
                                                    @PathVariable("eventId") Long eventId) {
        if (EventSource.getEvent(eventId).getOwner().getId() == calendarId){
            return EventSource.getEvent(eventId);
        }
        return null;
    }

    @RequestMapping(value = "/users/{userId}/calendars/{calendarId}/events/add", method = RequestMethod.POST)
    public void add(@PathVariable("userId") Long userId,
                    @PathVariable("calendarId") Long calendarId,
                    @RequestBody Event input){
        EventSource.addEvent(input.getName(), input.getFechaInicio(),
                input.getFechaFin(), input.getHoraInicio(), input.getHoraFin(), calendarId);
    }

    @RequestMapping(value = "/users/{userId}/calendars/{calendarId}/events/{eventId}/delete",
            method = RequestMethod.DELETE)
    public void delete(@PathVariable("calendarId") Long calendarId,
                       @PathVariable("userId") Long userId,
                       @PathVariable("eventId") Long eventId){
        if (EventSource.getEvent(eventId).getOwner().getId() == calendarId){
            EventSource.deleteEvent(calendarId);
        }
    }

    @RequestMapping(value = "/users/{userId}/calendars/{calendarId}/events/{eventId}/update", method = RequestMethod.PUT)
    public void update(@PathVariable("calendarId") Long calendarId,
                       @PathVariable("userId") Long userId,
                       @PathVariable("eventId") Long eventId,
                       @RequestBody Calendar input){
//        if (CalendarSource.getCalendar(calendarId).getOwner().getId() == userId){
//            CalendarSource.updateCalendar(calendarId, input.getName());
//        }
    }
}
