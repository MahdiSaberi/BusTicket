package ir.bustick.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/ticket")
public class TicketController {

    @RequestMapping(method = RequestMethod.GET)
    public String ticketTable(ModelMap model){

        model.addAttribute("message","Helloa");
        return "search-table";
    }
}
