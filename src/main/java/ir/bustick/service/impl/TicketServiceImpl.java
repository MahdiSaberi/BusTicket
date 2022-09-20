//package ir.bustick.service.impl;
//
//
//import ir.bustick.entity.Ticket;
//import ir.bustick.repository.TicketRepository;
//import ir.bustick.repository.UserRepository;
//import ir.bustick.service.TicketService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@Service
//public class TicketServiceImpl implements TicketService {
//
//    @Autowired
//    private TicketRepository ticketRepository;
//
//    @Override
//    @Transactional
//    public Ticket save(Ticket ticket) {
//        return ticketRepository.save(ticket);
//    }
//
//    @Override
//    @Transactional
//    public Ticket update(Ticket ticket) {
//        return ticketRepository.update(ticket);
//    }
//
//    @Override
//    @Transactional
//    public Ticket findById(Long id) {
//        return ticketRepository.findById(id);
//    }
//
//    @Override
//    @Transactional
//    public List<Ticket> findAll() {
//        return ticketRepository.findAll();
//    }
//
//    @Override
//    @Transactional
//    public void delete(Ticket ticket) {
//        ticketRepository.delete(ticket);
//    }
//
//    @Override
//    @Transactional
//    public void deleteById(Long id) {
//        ticketRepository.deleteById(id);
//    }
//}
