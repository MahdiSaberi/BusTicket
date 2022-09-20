package ir.bustick.repository.impl;

import ir.bustick.entity.User;
import ir.bustick.repository.UserRepository;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

//    @Autowired
//    private SessionFactory entityManager;

    @Autowired
    private EntityManager entityManager;

    @Override
    public User save(User user) {
        entityManager.persist(user);
        return user;
    }

    @Override
    public User update(User user) {
        entityManager.merge(user);
        return user;
    }

    @Override
    public User findById(Long id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> eList = entityManager.createQuery("select u from "+User.class.getSimpleName()+" u", User.class).getResultList();
        return eList;
    }

    @Override
    public void delete(User user) {
        entityManager.remove(user);
    }

    @Override
    public void deleteById(Long id) {
        User user = findById(id);
        entityManager.remove(user);
    }
}
