package ir.bustick.service.impl;


import ir.bustick.entity.Ticket;
import ir.bustick.repository.TicketRepository;
import ir.bustick.repository.UserRepository;
import ir.bustick.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    private TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
//    @Transactional
    public Ticket save(Ticket ticket) {
        ticketRepository.begin();
        ticketRepository.save(ticket);
        ticketRepository.commit();
        return ticket;
    }

    @Override
//    @Transactional
    public Ticket update(Ticket ticket) {
        ticketRepository.begin();
        ticketRepository.update(ticket);
        ticketRepository.commit();
        return ticket;
    }

    @Override
//    @Transactional
    public Ticket findById(Long id) {
        ticketRepository.begin();
        System.out.println("HERE");
        Ticket ticket = ticketRepository.findById(id);
        ticketRepository.commit();
        return ticket;
    }

    @Override
//    @Transactional
    public List<Ticket> findAll() {
        ticketRepository.begin();
        List<Ticket> tickets = ticketRepository.findAll();
        ticketRepository.commit();
        return tickets;
    }

    @Override
//    @Transactional
    public void delete(Ticket ticket) {
        ticketRepository.begin();
        ticketRepository.delete(ticket);
        ticketRepository.commit();
    }

    @Override
//    @Transactional
    public void deleteById(Long id) {
        ticketRepository.begin();
        ticketRepository.deleteById(id);
        ticketRepository.commit();
    }

    public List<Ticket> findByODD(String origin, String destination, String date){

        try {
            ticketRepository.begin();
            List<Ticket> tickets = ticketRepository.findByODD(origin, destination, date);
            ticketRepository.commit();
            return tickets;
        }catch (Exception exception){
            System.out.println("Tickets not found!");
            ticketRepository.rollback();
            return null;
        }
    }

    @Override
    public Ticket findByTravelId(String travelId) {

        try{
            ticketRepository.begin();
            Ticket ticket = ticketRepository.findByTravelId(travelId);
            ticketRepository.commit();
            return ticket;
        }catch (Exception exception){
            System.out.println("Something went wrong.");
            ticketRepository.rollback();
            return null;
        }
    }
}
