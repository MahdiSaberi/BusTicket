package ir.bustick.repository.impl;

import ir.bustick.entity.User;
import ir.bustick.repository.UserRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl extends TransactionRepositoryImpl implements UserRepository {

    private EntityManager entityManager;

    public UserRepositoryImpl(EntityManager entityManager, EntityManager entityManager1) {
        super(entityManager);
        this.entityManager = entityManager1;
    }

    @Override
//    @Transactional
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

    @Override
    public User findByUserAndPassword(String username, String password) {
        return entityManager.createQuery("select u from User u where u.username =: username and u.password =: password",User.class)
                .setParameter("username",username).setParameter("password",password).getSingleResult();
    }

    @Override
    public User findByUsername(String username) {
        return entityManager.createQuery("select u from User u where u.username =: username",User.class)
                .setParameter("username",username).getSingleResult();
    }

}
