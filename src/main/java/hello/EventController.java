package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by arcangel on 23/11/16.
 */
@RestController
public class EventController {
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/event")
    public Event eventData(@RequestParam(value="name") String name) {
        return new Event(counter.incrementAndGet(), name);
    }

    @RequestMapping("/event/list")
    public List<Event> listAllevents() {
        return new ArrayList<Event>();
    }

    @RequestMapping("/event/add")
    public void add(){
        System.out.println("Not implemented");
    }

    @RequestMapping("/event/delete")
    public void delete(){
        System.out.println("Not implemented");
    }

    @RequestMapping("/event/change")
    public void change(){
        System.out.println("Not implemented");
    }
}
