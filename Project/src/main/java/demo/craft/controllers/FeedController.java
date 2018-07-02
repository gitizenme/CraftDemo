package demo.craft.controllers;

import demo.craft.services.IAuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.MessageFormat;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class FeedController {
    private static final Logger logger = LoggerFactory.getLogger(FeedController.class);

    @Autowired
    private IAuthenticationService authenticationService;

    @RequestMapping(value = "/feed", method = GET)
    @ResponseBody
    public String feed() {
        String userId = authenticationService.currentUserId();
        // for the current userId get the 100 recent messages
        logger.debug(MessageFormat.format("Getting messages for {0}", userId));

        return String.format("Hello, %s!\n%s", authenticationService.currentUserName(), "<p><h2>Latest Posts</h2></p><p><a href=\"/logout\">Logout</a></p>");
    }

}
