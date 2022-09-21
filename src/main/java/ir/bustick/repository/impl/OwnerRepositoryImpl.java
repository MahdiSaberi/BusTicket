package ir.bustick.repository.impl;


import ir.bustick.entity.Owner;
import ir.bustick.entity.Owner;
import ir.bustick.entity.Owner;
import ir.bustick.repository.OwnerRepository;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OwnerRepositoryImpl extends TransactionRepositoryImpl implements OwnerRepository {

    private EntityManager entityManager;

    public OwnerRepositoryImpl(EntityManager entityManager, EntityManager entityManager1) {
        super(entityManager);
        this.entityManager = entityManager1;
    }

    @Override
    public Owner save(Owner owner) {
        entityManager.persist(owner);
        return owner;
    }

    @Override
    public Owner update(Owner owner) {
        entityManager.merge(owner);
        return owner;
    }

    @Override
    public Owner findById(Long id) {
        Owner owner = entityManager.find(Owner.class, id);
        return owner;
    }

    @Override
    public List<Owner> findAll() {
        List<Owner> eList = entityManager.createQuery("select u from "+Owner.class.getSimpleName()+" u", Owner.class).getResultList();
        return eList;
    }

    @Override
    public void delete(Owner owner) {
        entityManager.remove(owner);
    }

    @Override
    public void deleteById(Long id) {
        Owner owner = findById(id);
        entityManager.remove(owner);
    }

    @Override
    public List<Owner> findByUserId(Long id) {
        return entityManager.createQuery("select o from Owner o where o.user.id =: id",Owner.class)
                .setParameter("id",id).getResultList();
    }
}
