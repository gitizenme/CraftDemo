package demo.craft.controllers;

import demo.craft.models.*;
import demo.craft.services.IAuthenticationService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.text.MessageFormat;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class CraftController {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CraftController.class);

    @Autowired
    private IAuthenticationService authenticationService;

    @Autowired
    UserRepository users;

    @Autowired
    MessageRepository messages;

    @RequestMapping(value = "/", method = GET)
    @ResponseBody
    public String index() {
        String userId = authenticationService.currentUserId();
        logger.info(MessageFormat.format("dn = {0}", userId));

        logger.info("User findAll()");
        for (User user: users.findAll()) {
            logger.info(user.toString());
        }

        logger.info("Messages findAll()");
        for (Message message: messages.findAll()) {
            logger.info(message.toString());
        }


        return String.format("Hello, %s!\n%s", authenticationService.currentUserName(), "\n<ul><li><a href=\"/feed\">Feed</a></li><li><a href=\"/logout\">Logout</a></li></ul>");
    }

    @RequestMapping(value = "/logout", method = GET)
    public RedirectView logout(HttpServletRequest request, HttpServletResponse response, RedirectAttributes attributes)
    {
        // logout
        authenticationService.logout(request, response);
        // redirect
        attributes.addFlashAttribute("flashAttribute", "redirectWithRedirectView");
        attributes.addAttribute("attribute", "redirectWithRedirectView");
        return new RedirectView("/");
    }

    @RequestMapping(value = "/ping", method = GET)
    @ResponseBody
    public Ping ping() {
        return new Ping();
    }


}
