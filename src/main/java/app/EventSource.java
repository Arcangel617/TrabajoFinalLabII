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
        Event event1 = new Event(counter.incrementAndGet(), "Pasear Nina", "01/01/2016",
                "01/01/2017", "19:00:00", "19:00:00",1);
        Event event2 = new Event(counter.incrementAndGet(), "Consulta Veterinario Lulu",
                "05/12/2016","05/12/2016","10:00:00", "10:00:00",2);
        Event event3 = new Event(counter.incrementAndGet(), "Consulta Veterinario Katy", "28/11/2016",
                "05/12/2016", "10:00:00", "10:00:00",3);
        Event event4 = new Event(counter.incrementAndGet(), "Cambiar collar antipulgas Pancho",
                "30/11/2016","19/12/2016","11:00:00", "11:00:00",4);
        Event event5 = new Event(counter.incrementAndGet(), "Antibiótico Firulais", "27/11/2016",
                "01/12/2016", "12:30:00", "12:30:00",5);
        Event event6 = new Event(counter.incrementAndGet(), "Antibiótico Firulais", "28/11/2016",
                "01/12/2016", "00:30:00", "00:30:00",5);

        EVENTS.put(event1.getId(), event1);
        EVENTS.put(event2.getId(), event2);
        EVENTS.put(event3.getId(), event3);
        EVENTS.put(event4.getId(), event4);
        EVENTS.put(event5.getId(), event5);
        EVENTS.put(event6.getId(), event6);
    }

    public static Collection<Event> getEvents() {
        return EVENTS.values();
    }

    public static Event getEvent(Long eventId){
        return EVENTS.get(eventId);
    }

    public static void addEvent(String name, String fechaInicio, String fechaFin,
                                String horaInicio, String horaFin, Long calendarId){
        Event e = new Event(counter.incrementAndGet(), name, fechaInicio, fechaFin, horaInicio, horaFin, calendarId);
        EVENTS.put(e.getId(), e);
    }

    public static void deleteEvent(Long eventId){
        EVENTS.remove(eventId);
    }

    public static void updateEvent(Long eventId, String name, String fechaInicio, String fechaFin,
                                   String horaInicio, String horaFin){
        Event e = EventSource.getEvent(eventId);
    }
}
