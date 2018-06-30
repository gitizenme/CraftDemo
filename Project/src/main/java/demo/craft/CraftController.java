package demo.craft;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class CraftController {

    @RequestMapping(value = "/ping", method = GET)
    public @ResponseBody String ping() {
        return "PING: " + new Date().toString();
    }

}
