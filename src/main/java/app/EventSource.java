package app;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by arcangel on 27/11/16.
 */
public class EventSource {
    private static final Map<Long, Event> EVENTS = new HashMap<>();
    private static final AtomicLong counter = new AtomicLong();
    static {
        Event event1 = new Event(counter.incrementAndGet(), "Evento del Calendario de Nina", "28/11/2016",
                "29/11/2016", "17:23:00", "19:00:00");
        Event event2 = new Event(counter.incrementAndGet(), "Evento del Calendario de Lulu",
                "30/11/2016","01/12/2016","08:30:00", "10:30:00");
        Event event3 = new Event(counter.incrementAndGet(), "Evento del Calendario de Katy", "28/11/2016",
                "28/11/2016", "17:23:00", "19:00:00");
        Event event4 = new Event(counter.incrementAndGet(), "Evento del Calendario de Pancho",
                "30/11/2016","01/12/2016","08:30:00", "10:30:00");
        Event event5 = new Event(counter.incrementAndGet(), "Evento del Calendario de Firulais", "28/11/2016",
                "29/11/2016", "17:23:00", "19:00:00");

        EVENTS.put(event1.getId(), event1);
        EVENTS.put(event2.getId(), event2);
        EVENTS.put(event3.getId(), event3);
        EVENTS.put(event4.getId(), event4);
        EVENTS.put(event4.getId(), event5);
    }

    /**
     * Devuelve una coleccion con todos los calendarios.
     * @return una coleccion de calendarios
     */
    public static Collection<Event> getEvents() {
        return EVENTS.values();
    }

    /**
     * Devuelve el calendario que se pasa como parámetro
     * @param eventId
     * @return un objeto de tipo Calendar
     */
    public static Event getEvent(Long eventId){
        return EVENTS.get(eventId);
    }

    /**
     * Agrega un evento.
     * @param name
     * @param calendarId
     */
    public static void addEvent(String name, Long calendarId){
//        Event e = new Event(counter.incrementAndGet(), name, calendarId);
//        EVENTS.put(e.getId(), e);
    }

    /**
     * Borra el calendario que se pasa como parámetro.
     * @param eventId
     */
    public static void deleteCalendar(Long eventId){
        EVENTS.remove(eventId);
    }

    /**
     * Actualiza los datos del calendario que se pasa como parámetro.
     * @param calendarId
     * @param name
     */
    public static void updateCalendar(Long calendarId, String name){
//        Calendar c = getCalendar(calendarId);
//        c.setName(name);
    }
}
