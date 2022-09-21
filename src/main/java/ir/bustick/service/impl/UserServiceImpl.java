package ir.bustick.service.impl;

import ir.bustick.entity.User;
import ir.bustick.repository.UserRepository;
import ir.bustick.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

//    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
//    @Transactional
    public User save(User user) {
        userRepository.begin();
        userRepository.save(user);
        userRepository.commit();
        return user;
    }

    @Override
//    @Transactional
    public User update(User user) {
        userRepository.begin();
        userRepository.update(user);
        userRepository.commit();
        return user;
    }

    @Override
//    @Transactional
    public User findById(Long id) {
        userRepository.begin();
        User user = userRepository.findById(id);
        userRepository.commit();
        return user;
    }

    @Override
//    @Transactional
    public List<User> findAll() {
        userRepository.begin();
        List<User> users = userRepository.findAll();
        userRepository.commit();
        return users;
    }

    @Override
//    @Transactional
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
//    @Transactional
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findByUserAndPassword(String username, String password) {
        try {
            if(!userRepository.getTransaction().isActive())
                userRepository.begin();
            User user = userRepository.findByUserAndPassword(username,password);
            userRepository.commit();
            return user;

        }catch (Exception ex){
            System.out.println("Wrong username or password!");
            userRepository.rollback();
            return null;
        }
    }

    @Override
    public User findByUsername(String username) {
        try {
            if(!userRepository.getTransaction().isActive())
                userRepository.begin();
            User user = userRepository.findByUsername(username);
            userRepository.commit();
            return user;

        }catch (Exception ex){
            System.out.println("Something went wrong!");
            userRepository.rollback();
            return null;
        }
    }
}
