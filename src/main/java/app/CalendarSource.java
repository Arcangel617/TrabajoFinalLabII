package app;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by arcangel on 23/11/16.
 */
public class CalendarSource {
    private static final Map<Long, Calendar> CALENDARS = new HashMap<>();
    private static final AtomicLong counter = new AtomicLong();
    static {
        Calendar calendar1 = new Calendar(counter.incrementAndGet(), "Calendario de Nina", 2);
        Calendar calendar2 = new Calendar(counter.incrementAndGet(), "Calendario de Lulu", 2);
        Calendar calendar3 = new Calendar(counter.incrementAndGet(), "Calendario de Katy", 2);
        Calendar calendar4 = new Calendar(counter.incrementAndGet(), "Calendario de Pancho", 1);
        Calendar calendar5 = new Calendar(counter.incrementAndGet(), "Calendario de Firulais", 1);

        CALENDARS.put(calendar1.getId(), calendar1);
        CALENDARS.put(calendar2.getId(), calendar2);
        CALENDARS.put(calendar3.getId(), calendar3);
        CALENDARS.put(calendar4.getId(), calendar4);
        CALENDARS.put(calendar5.getId(), calendar5);
    }

    /**
     * Devuelve una coleccion con todos los calendarios.
     * @return una coleccion de calendarios
     */
    public static Collection<Calendar> getCalendars() {
        return CALENDARS.values();
    }

    /**
     * Devuelve el calendario que se pasa como parámetro
     * @param calendarId
     * @return un objeto de tipo Calendar
     */
    public static Calendar getCalendar(Long calendarId){
        return CALENDARS.get(calendarId);
    }

    /**
     * Agrega un calendario.
     * @param name
     * @param userId
     */
    public static void addCalendar(String name, Long userId){
        Calendar c = new Calendar(counter.incrementAndGet(), name, userId);
        CALENDARS.put(c.getId(), c);
    }

    /**
     * Borra el calendario que se pasa como parámetro.
     * @param id
     */
    public static void deleteCalendar(Long id){
        CALENDARS.remove(id);
    }

    /**
     * Actualiza los datos del calendario que se pasa como parámetro.
     * @param calendarId
     * @param name
     */
    public static void updateCalendar(Long calendarId, String name){
        Calendar c = getCalendar(calendarId);
        c.setName(name);
    }
}
