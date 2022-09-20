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
public class OwnerRepositoryImpl implements OwnerRepository {

    @Autowired
    private EntityManager entityManager;

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
}
