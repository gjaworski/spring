package jaworskg.spring.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class RedirectionController {

    @RequestMapping(value = "/redirect1", method = GET)
    public String redirect1() {
        return "redirect:https://wp.pl";
    }

    @RequestMapping(value = "/redirect2", method = GET)
    public ModelAndView redirect2() {
        return new ModelAndView("redirect:https://www.trojmiasto.pl");
    }

    @RequestMapping(value = "/redirect3", method = GET)
    public RedirectView redirect3() {
        return new RedirectView("https://www.onet.pl");
    }

}
