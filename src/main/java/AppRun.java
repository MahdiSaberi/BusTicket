import ir.bustick.config.WebConfig;
import ir.bustick.entity.Owner;
import ir.bustick.entity.Ticket;
import ir.bustick.entity.User;
import ir.bustick.repository.impl.OwnerRepositoryImpl;
import ir.bustick.repository.impl.TicketRepositoryImpl;
import ir.bustick.repository.impl.UserRepositoryImpl;
import ir.bustick.service.OwnerService;
import ir.bustick.service.TicketService;
import ir.bustick.service.UserService;
import ir.bustick.service.impl.OwnerServiceImpl;
import ir.bustick.service.impl.TicketServiceImpl;
import ir.bustick.service.impl.UserServiceImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;


public class AppRun {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        OwnerService ownerService = new OwnerServiceImpl(new OwnerRepositoryImpl(entityManager,entityManager));
        UserService userService = new UserServiceImpl(new UserRepositoryImpl(entityManager,entityManager));
        TicketService ticketService = new TicketServiceImpl(new TicketRepositoryImpl(entityManager));
        User user = userService.findById(1L);
        Ticket ticket = ticketService.findById(1L);
        Owner owner = new Owner("ali","male",user);
        owner.setTicket(ticket);

        ownerService.save(owner);

    }
}
