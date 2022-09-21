package ir.bustick.service;


import ir.bustick.entity.Owner;

import java.util.List;

public interface OwnerService{
    Owner save(Owner owner);
    Owner update(Owner owner);

    Owner findById(Long id);
    List<Owner> findAll();

    void delete(Owner owner);
    void deleteById(Long id);

    List<Owner> findByUserId(Long id);
}
