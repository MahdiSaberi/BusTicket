package ir.bustick.controller;

import ir.bustick.entity.Owner;
import ir.bustick.entity.Ticket;
import ir.bustick.entity.User;
import ir.bustick.service.OwnerService;
import ir.bustick.service.TicketService;
import ir.bustick.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/ticket")
public class TicketController {

    private TicketService ticketService;

    private OwnerService ownerService;

    private UserService userService;

    public TicketController(TicketService ticketService, OwnerService ownerService,UserService userService) {
        this.ticketService = ticketService;
        this.ownerService = ownerService;
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String ticketTable(Model model,HttpSession session){
        List<Ticket> tickets = (List<Ticket>) session.getAttribute("tickets");
        return "search-table";
    }

    @PostMapping("")
    public String showTickets(@ModelAttribute("owner") Owner owner, HttpSession session, HttpServletRequest request){

        String travelID = request.getParameter("travelID");

        User userNullId = (User) session.getAttribute("user");

        User user = userService.findByUsername(userNullId.getUsername());
        Ticket ticket = ticketService.findByTravelId(travelID);

        Owner owner1 = new Owner(owner.getName(), owner.getGender(),user);
        owner1.setTicket(ticket);
        ownerService.save(owner1);

        String name = owner.getName();

        String gender;
        if(owner.getGender().equals("male"))
            gender = "Mr.";
        else
            gender = "Mrs.";

        String message = gender+" "+name+", Your Ticket Reserved Successfully!";

        session.setAttribute("owner",owner1);
        session.setAttribute("message",message);

        return "message";

    }

    @PostMapping("/remove")
    public String refund(HttpServletRequest request){
        Long ownerId = Long.valueOf(request.getParameter("travelRefund"));
        ownerService.deleteById(ownerId);
        return "redirect:/usertickets";
    }
}
