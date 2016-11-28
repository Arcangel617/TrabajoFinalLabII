package app;

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

    /**
     * Devuelve una coleccion con todos los usuarios
     * @return una coleccion con usuarios
     */
    public static Collection<User> getUsers() {
        return USERS.values();
    }

    /**
     * Devuelve los datos de un usuario que se pasa como parametro
     * @param userId
     * @return un objeto de tipo usuario
     */
    public static User getUser(Long userId) {
        return USERS.get(userId);
    }

    /**
     * Agrega un usuario a la coleccion. Recibe como parametro el nombre y
     * el email del usuario a agregar. Se instancia un usuario y se lo agrega
     * a la coleccion.
     * @param name
     * @param email
     */
    public static void addUser(String name, String email){
        User u = new User(counter.incrementAndGet(), name, email);
        USERS.put(u.getId(), u);
    }

    /**
     * Borra de la coleccion el usuario que tenga el id que se pasa como
     * parámetro.
     * @param id
     */
    public static void deleteUser(Long id){
        USERS.remove(id);
    }

    /**
     * Actualiza los datos del usuario. Recibe el id del usuario a actualizar y el
     * email nuevo.
     * @param id
     * @param email
     */
    public static void updateUser(Long id, String email){
        User u = getUser(id);
        u.setEmail(email);
    }

    /**
     * Verifica si un usuario existe.
     * @param userId
     * @return
     */
    public static boolean exists(Long userId){
        if (USERS.get(userId) != null){
            return true;
        }
        return false;
    }
}
