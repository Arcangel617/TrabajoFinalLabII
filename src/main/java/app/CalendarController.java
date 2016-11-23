package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by arcangel on 23/11/16.
 */
@RestController
public class CalendarController {

    @RequestMapping("/calendar/list")
    public Collection<Calendar> listAllCalendars() {
        return CalendarSource.getCalendars();
    }

    @RequestMapping("/calendar/add")
    public void add(){
        System.out.println("Not implemented");
    }

    @RequestMapping("/calendar/delete")
    public void delete(){
        System.out.println("Not implemented");
    }

    @RequestMapping("/calendar/change")
    public void change(){
        System.out.println("Not implemented");
    }
}
