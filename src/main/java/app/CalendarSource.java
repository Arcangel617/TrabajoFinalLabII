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
        Calendar calendar1 = new Calendar(counter.incrementAndGet(), "Calendario de Arcangel" );
        Calendar calendar2 = new Calendar(counter.incrementAndGet(), "Calendario de Romina" );
        Calendar calendar3 = new Calendar(counter.incrementAndGet(), "Calendario de Franco" );
        Calendar calendar4 = new Calendar(counter.incrementAndGet(), "Calendario de Andrés" );

        CALENDARS.put(calendar1.getId(), calendar1);
        CALENDARS.put(calendar2.getId(), calendar2);
        CALENDARS.put(calendar3.getId(), calendar3);
        CALENDARS.put(calendar4.getId(), calendar4);
    }

    public static Collection<Calendar> getCalendars() {
        return CALENDARS.values();
    }
}
