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
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public Collection<User> getAllUsers() {
        return UserSource.getUsers();
    }

    /**
     * Duevelve los datos de un usuario del cual se especifica el id
     * @return el usuario solicitado
     */
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable("id") long id) {
        return UserSource.getUser(id);
    }

    /**
     * Inserta un nuevo usuario
     * @param input
     */
    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public void add(@RequestBody() User input){
        UserSource.addUser(input.getName(), input.getEmail());
    }

    /**
     * Borra el usuario que se especifica en la url
     * @param id
     */
    @RequestMapping(value = "/users/{id}/delete", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") Long id){
        UserSource.deleteUser(id);
    }

    /**
     * Modifica los datos de un usuario
     * @param id
     * @param input
     */
    @RequestMapping(value = "/users/{id}/update", method = RequestMethod.PUT)
    public void update(@PathVariable(value = "id") Long id, @RequestBody User input){
        UserSource.updateUser(id,input.getEmail());
    }

    /**
     * Filtra usuarios por direccion de correo
     * @param email
     * @return
     */
    @RequestMapping(value = "/users/filter", method = RequestMethod.GET)
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
}
