package demo.craft.controllers;

import demo.craft.models.PingResponse;
import demo.craft.services.IAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.ldap.userdetails.LdapUserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class CraftController {

    private static final Logger logger = Logger.getLogger(CraftController.class.getName());

    @Autowired
    private IAuthenticationService authenticationService;

    @RequestMapping(value = "/", method = GET)
    @ResponseBody
    public String index(Authentication authentication) {
        LdapUserDetails user = (LdapUserDetails) authentication.getPrincipal();
        String dn = user.getDn();
        logger.log(Level.INFO, String.format("dn = %s", dn));
        return String.format("Hello, %s!\n%s", user.getUsername(), "\n<ul><li><a href=\"/feed\">Feed</a></li><li><a href=\"/logout\">Logout</a></li></ul>");
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
    public PingResponse ping() {
        return new PingResponse();
    }


}
