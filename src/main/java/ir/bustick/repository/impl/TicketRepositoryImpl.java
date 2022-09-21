package ir.bustick.repository.impl;

import ir.bustick.entity.Ticket;
import ir.bustick.entity.Ticket;
import ir.bustick.entity.Ticket;
import ir.bustick.repository.TicketRepository;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TicketRepositoryImpl extends TransactionRepositoryImpl implements TicketRepository {

    private EntityManager entityManager;

    public TicketRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public Ticket save(Ticket ticket) {
        entityManager.persist(ticket);
        return ticket;
    }

    @Override
    public Ticket update(Ticket ticket) {
        entityManager.merge(ticket);
        return ticket;
    }

    @Override
    public Ticket findById(Long id) {
        System.out.println("HERE");
        Ticket ticket = entityManager.find(Ticket.class, id);
        return ticket;
    }

    @Override
    public List<Ticket> findAll() {
        List<Ticket> eList = entityManager.createQuery("select u from "+Ticket.class.getSimpleName()+" u", Ticket.class).getResultList();
        return eList;
    }

    @Override
    public void delete(Ticket ticket) {
        entityManager.remove(ticket);
    }

    @Override
    public void deleteById(Long id) {
        Ticket ticket = findById(id);
        entityManager.remove(ticket);
    }

    @Override
    public List<Ticket> findByODD(String origin, String destination, String date) {

        List<Ticket> tickets = entityManager.createQuery("select t from Ticket t where t.date =: date and t.orig =: origin and t.dest =: dest",Ticket.class)
                .setParameter("date",date)
                .setParameter("origin",origin)
                .setParameter("dest",destination).getResultList();

        return tickets;
    }

    @Override
    public Ticket findByTravelId(String travelId) {
        Ticket ticket = entityManager.createQuery("select t from Ticket t where t.travelID=:travelId",Ticket.class).setParameter("travelId",travelId).getSingleResult();

        return ticket;
    }
}
