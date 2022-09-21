package ir.bustick.service.impl;

import ir.bustick.entity.Owner;
import ir.bustick.repository.OwnerRepository;
import ir.bustick.repository.UserRepository;
import ir.bustick.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {

    private OwnerRepository ownerRepository;

    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
//    @Transactional
    public Owner save(Owner owner) {

        try {
            if (!ownerRepository.getTransaction().isActive()) {
                ownerRepository.begin();
            }
            ownerRepository.save(owner);
            ownerRepository.commit();
        }catch (Exception e){
            System.out.println("Cannot save this Owner!");
            e.printStackTrace();
            ownerRepository.rollback();
        }
        return owner;
    }

    @Override
//    @Transactional
    public Owner update(Owner owner) {
        ownerRepository.begin();
        ownerRepository.update(owner);
        ownerRepository.commit();
        return owner;
    }

    @Override
//    @Transactional
    public Owner findById(Long id) {
        ownerRepository.begin();
        Owner owner = ownerRepository.findById(id);
        ownerRepository.commit();
        return owner;
    }

    @Override
//    @Transactional
    public List<Owner> findAll() {

        ownerRepository.begin();
        List<Owner> owners = ownerRepository.findAll();
        ownerRepository.commit();
        return owners;
    }

    @Override
//    @Transactional
    public void delete(Owner owner) {
        ownerRepository.begin();
        ownerRepository.delete(owner);
        ownerRepository.commit();
    }

    @Override
//    @Transactional
    public void deleteById(Long id) {
        ownerRepository.begin();
        ownerRepository.deleteById(id);
        ownerRepository.commit();
    }

    @Override
    public List<Owner> findByUserId(Long id) {
        try {
            ownerRepository.begin();
            List<Owner> owners = ownerRepository.findByUserId(id);
            ownerRepository.commit();
            return owners;
        }catch (Exception e){
            System.out.println("I can't");
            ownerRepository.rollback();
            return null;
        }

    }
}