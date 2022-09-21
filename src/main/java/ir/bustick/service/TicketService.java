package ir.bustick.service;



import ir.bustick.entity.Ticket;

import java.util.List;

public interface TicketService {
    Ticket save(Ticket ticket);
    Ticket update(Ticket ticket);

    Ticket findById(Long id);
    List<Ticket> findAll();

    void delete(Ticket ticket);
    void deleteById(Long id);

    List<Ticket> findByODD(String origin,String destination,String date);
    Ticket findByTravelId(String travelId);
}
