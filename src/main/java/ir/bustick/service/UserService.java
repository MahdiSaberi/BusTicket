package ir.bustick.service;


import ir.bustick.entity.User;

import java.util.List;

public interface UserService {
    User save(User user);
    User update(User user);

    User findById(Long id);
    List<User> findAll();

    void delete(User user);
    void deleteById(Long id);
}
