package app;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.web.bind.annotation.*;

/**
 * Created by arcangel on 23/11/16.
 */
@RestController
public class UserController {

    /**
     * Por defecto lista todos los usuarios disponibles
     * @return una lista de usuarios
     */
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public Collection<User> getAllUsers() {
        return UserSource.getUsers();
    }

    /**
     * Duevelve los datos de un usuario del cual se especifica el id
     * @return el usuario solicitado
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable("id") long id) {
        return UserSource.getUser(id);
    }

    /**
     * Filtra usuarios por direccion de correo
     * @param email
     * @return
     */
    @RequestMapping(value = "/user/filter", method = RequestMethod.GET)
    public Collection<User> getByEmail(@RequestParam(value="email", defaultValue = "all") String email) {
        if (email.equals("all")){
            return UserSource.getUsers();
        } else {
            Collection result = new ArrayList();
            for (User u : UserSource.getUsers()) {
                if (u.getEmail().equals(email)){
                    result.add(u);
                }
            }
            return result;
        }
    }

    /**
     * Duevelve los datos de un usuario del cual se especifica el id
     * @return el usuario solicitado
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable("id") Long id) {
        return UserSource.getUser(id);
    }

    /**
     * Inserta un nuevo usuario
     * @param name
     * @param email
     */
    @RequestMapping(value = "user/add", method = RequestMethod.POST)
    public void add(@RequestParam(value = "name") String name, @RequestParam(value ="email") String email){
        UserSource.addUser(name, email);
    }

    /**
     * Borra el usuario que se especifica en la url
     * @param id
     */
    @RequestMapping("user/delete/{id}")
    public void delete(@PathVariable(value = "id") Long id){
        UserSource.deleteUser(id);
    }

    @RequestMapping("user/change")
    public void change(){
        System.out.println("Not implemented");
    }
}
