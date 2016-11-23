package hello;

import java.util.ArrayList;
import java.util.Collection;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by arcangel on 23/11/16.
 */
@RestController
public class UserController {

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User getById(@RequestParam(value="userId") Long id) {
        return UserSource.getUser(id);
    }

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

    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    public Collection<User> listAllUsers() {
        return UserSource.getUsers();
    }

    @RequestMapping(value = "user/add", method = RequestMethod.GET)
    public void add(@RequestParam(value = "name") String name, @RequestParam(value ="email") String email){
        UserSource.addUser(name, email);
    }

    @RequestMapping("user/delete")
    public void delete(@RequestParam(value = "userId") Long id){
        UserSource.deleteUser(id);
    }

    @RequestMapping("user/change")
    public void change(){
        System.out.println("Not implemented");
    }
}
