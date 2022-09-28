package ir.bustick.controller;

import ir.bustick.entity.Owner;
import ir.bustick.entity.Ticket;
import ir.bustick.entity.User;
import ir.bustick.service.OwnerService;
import ir.bustick.service.TicketService;
import ir.bustick.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/usertickets")
public class UserTicketController {

    private UserService userService;
    private OwnerService ownerService;

    public UserTicketController(UserService userService, OwnerService ownerService) {
        this.userService = userService;
        this.ownerService = ownerService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String userTickets(HttpSession session){

        if (session.getAttribute("user") == null)
            return "access-denied";

        List<Owner> owners = ownerService.findAll();
        session.setAttribute("owners",owners);
        System.out.println("SIZEOF: "+owners.size());
        User username = (User) session.getAttribute("user");
        User user = userService.findByUsername(username.getUsername());
        session.setAttribute("ticketUser",user);

        List<Ticket> userTickets = new ArrayList<>();
        for (Owner owner : owners) {
            if (owner.getUser().getId() == user.getId())
                userTickets.add(owner.getTicket());
        }


        return "user-tickets";
    }
}
