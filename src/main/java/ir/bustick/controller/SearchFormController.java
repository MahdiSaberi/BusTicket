package ir.bustick.controller;

import ir.bustick.entity.Owner;
import ir.bustick.entity.Ticket;
import ir.bustick.entity.User;
import ir.bustick.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/searchform")
public class SearchFormController {

    private final TicketService ticketService;

    public SearchFormController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showSearchForm(Model model, HttpSession session){
        User user = (User) session.getAttribute("user");

        return "search";
    }

    @PostMapping("")
    public String showTickets(@ModelAttribute("ticket") Ticket ticket, HttpSession session){

        try {
            List<Ticket> tickets = ticketService.findByODD(ticket.getOrig(),ticket.getDest(), ticket.getDate());
            session.setAttribute("tickets",tickets);
        }catch (Exception e){
            e.printStackTrace();
            return "redirect:/searchform";
        }

        return "redirect:/ticket";

    }
}
