//package ir.bustick.service.impl;
//
//import ir.bustick.entity.Owner;
//import ir.bustick.repository.OwnerRepository;
//import ir.bustick.repository.UserRepository;
//import ir.bustick.service.OwnerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@Service
//public class OwnerServiceImpl implements OwnerService {
//
//    @Autowired
//    private OwnerRepository ownerRepository;
//
//    @Override
//    @Transactional
//    public Owner save(Owner owner) {
//        return ownerRepository.save(owner);
//    }
//
//    @Override
//    @Transactional
//    public Owner update(Owner owner) {
//        return ownerRepository.update(owner);
//    }
//
//    @Override
//    @Transactional
//    public Owner findById(Long id) {
//        return ownerRepository.findById(id);
//    }
//
//    @Override
//    @Transactional
//    public List<Owner> findAll() {
//        return ownerRepository.findAll();
//    }
//
//    @Override
//    @Transactional
//    public void delete(Owner owner) {
//        ownerRepository.delete(owner);
//    }
//
//    @Override
//    @Transactional
//    public void deleteById(Long id) {
//        ownerRepository.deleteById(id);
//    }
//}