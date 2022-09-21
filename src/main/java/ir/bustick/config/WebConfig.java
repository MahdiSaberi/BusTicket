package ir.bustick.config;

import ir.bustick.entity.Ticket;
import ir.bustick.service.TicketService;
import ir.bustick.service.impl.TicketServiceImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"ir.bustick"})
public class WebConfig implements WebMvcConfigurer {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");

    @Autowired
    private TicketService ticketService;

    @Bean
    public EntityManager connectToDB(){
        return entityManagerFactory.createEntityManager();
    }

//    @Bean
    public void initTickets(){

            Ticket ticket0 = new Ticket("Tehran", "Qom", "2022-09-21", "23:30");
            Ticket ticket1 = new Ticket("Tehran", "Qom", "2022-09-21", "23:30");
            Ticket ticket2 = new Ticket("Tehran", "Qom", "2022-09-21", "17:30");
            Ticket ticket3 = new Ticket("Tehran", "Qom", "2022-09-21", "12:00");
            Ticket ticket4 = new Ticket("Mashhad", "Yazd", "2022-09-21", "15:00");
            Ticket ticket5 = new Ticket("Tehran", "Qazvin", "2022-09-21", "22:45");
            Ticket ticket6 = new Ticket("Mashhad", "Qom", "2022-09-21", "18:00");
            Ticket ticket7 = new Ticket("Qom", "Tehran", "2022-09-21", "19:00");
            Ticket ticket8 = new Ticket("Esfahan", "Bushehr", "2022-09-21", "20:20");
            Ticket ticket9 = new Ticket("Mashhad", "Qom", "2022-09-21", "21:00");

            ticketService.save(ticket0);
            ticketService.save(ticket1);
            ticketService.save(ticket2);
            ticketService.save(ticket3);
            ticketService.save(ticket4);
            ticketService.save(ticket5);
            ticketService.save(ticket6);
            ticketService.save(ticket7);
            ticketService.save(ticket8);
            ticketService.save(ticket9);

    }

}
