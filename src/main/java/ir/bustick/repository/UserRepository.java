package ir.bustick.repository;

import ir.bustick.entity.User;
import java.util.List;

public interface UserRepository{
    User save(User user);
    User update(User user);

    User findById(Long id);
    List<User> findAll();

    void delete(User user);
    void deleteById(Long id);
}
