package hello;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by arcangel on 23/11/16.
 */
public class UserSource {
    private static final Map<Long, User> USERS = new HashMap<>();
    private static final AtomicLong counter = new AtomicLong();
    static {
        User user1 = new User(counter.incrementAndGet(), "Artigue Arcangel Andres", "artigue_arcangel@hotmail.com" );
        User user2 = new User(counter.incrementAndGet(), "Brutti Romina", "brutti_romina@hotmail.com" );
        User user3 = new User(counter.incrementAndGet(), "Moglia Franco", "moglia_franco@hotmail.com" );
        User user4 = new User(counter.incrementAndGet(), "Salinas Andres", "salinas_andres@hotmail.com" );        

        USERS.put(user1.getId(), user1);
        USERS.put(user2.getId(), user2);
        USERS.put(user3.getId(), user3);
        USERS.put(user4.getId(), user4);
    }

    public static Collection<User> getUsers() {
        return USERS.values();
    }

    public static User getUser(Long userId) {
        return USERS.get(userId);
    }

    public static void addUser(String name, String email){
        User u = new User(counter.incrementAndGet(), name, email);
        USERS.put(u.getId(), u);
    }

    public static void deleteUser(Long id){
        USERS.remove(id);
    }
}
