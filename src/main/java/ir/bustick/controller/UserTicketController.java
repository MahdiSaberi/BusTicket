package ir.bustick.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/usertickets")
public class UserTicketController {

    @RequestMapping(method = RequestMethod.GET)
    public String userTickets(ModelMap model){
        return "user-tickets";
    }
}
