package ir.bustick.repository;

import ir.bustick.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface UserRepository extends TransactionRepository{

    User save(User user);
    User update(User user);

    User findById(Long id);
    List<User> findAll();

    void delete(User user);
    void deleteById(Long id);

    User findByUserAndPassword(String username,String password);
    User findByUsername(String username);

}
