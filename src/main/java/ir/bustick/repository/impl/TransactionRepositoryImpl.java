package ir.bustick.repository.impl;

import ir.bustick.repository.TransactionRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository {

    private EntityManager entityManager;

    public TransactionRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public EntityTransaction getTransaction() {

        return entityManager.getTransaction();
    }

    @Override
    public void begin() {
        if(!getTransaction().isActive())
            entityManager.getTransaction().begin();
    }

    @Override
    public void commit() {
        if(getTransaction().isActive())
            entityManager.getTransaction().commit();
    }

    @Override
    public void rollback() {
        entityManager.getTransaction().rollback();
    }
}
