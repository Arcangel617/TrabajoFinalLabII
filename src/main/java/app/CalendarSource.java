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
        Calendar calendar1 = new Calendar(counter.incrementAndGet(), "Calendario de Arcangel", 1);
        Calendar calendar2 = new Calendar(counter.incrementAndGet(), "Calendario de Romina", 2);
        Calendar calendar3 = new Calendar(counter.incrementAndGet(), "Calendario de Franco", 3);
        Calendar calendar4 = new Calendar(counter.incrementAndGet(), "Calendario de Andrés", 4);

        CALENDARS.put(calendar1.getId(), calendar1);
        CALENDARS.put(calendar2.getId(), calendar2);
        CALENDARS.put(calendar3.getId(), calendar3);
        CALENDARS.put(calendar4.getId(), calendar4);
    }

    public static Collection<Calendar> getCalendars() {
        return CALENDARS.values();
    }

    public static Calendar getCalendar(Long calendarId){
        return CALENDARS.get(calendarId);
    }

    public static void addCalendar(String name, Long userId){
        Calendar c = new Calendar(counter.incrementAndGet(), name, userId);
        CALENDARS.put(c.getId(), c);
    }

    public static void deleteCalendar(Long id){
        CALENDARS.remove(id);
    }

    public static void updateCalendar(Long calendarId, String name){
        Calendar c = getCalendar(calendarId);
        c.setName(name);
    }
}
