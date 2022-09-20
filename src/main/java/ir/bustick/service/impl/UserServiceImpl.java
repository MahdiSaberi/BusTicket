//package ir.bustick.service.impl;
//
//import ir.bustick.entity.User;
//import ir.bustick.repository.UserRepository;
//import ir.bustick.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@Service
//public class UserServiceImpl implements UserService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    @Transactional
//    public User save(User user) {
//        return userRepository.save(user);
//    }
//
//    @Override
//    @Transactional
//    public User update(User user) {
//        return userRepository.update(user);
//    }
//
//    @Override
//    @Transactional
//    public User findById(Long id) {
//        return userRepository.findById(id);
//    }
//
//    @Override
//    @Transactional
//    public List<User> findAll() {
//        return userRepository.findAll();
//    }
//
//    @Override
//    @Transactional
//    public void delete(User user) {
//        userRepository.delete(user);
//    }
//
//    @Override
//    @Transactional
//    public void deleteById(Long id) {
//        userRepository.deleteById(id);
//    }
//}
