package ir.bustick.repository;

import jakarta.persistence.EntityTransaction;

public interface TransactionRepository {
    void begin();
    void commit();
    void rollback();
    EntityTransaction getTransaction();
}
