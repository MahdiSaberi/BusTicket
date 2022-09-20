package ir.bustick.repository;


import ir.bustick.entity.Owner;

import java.util.List;

public interface OwnerRepository {
    Owner save(Owner owner);
    Owner update(Owner owner);

    Owner findById(Long id);
    List<Owner> findAll();

    void delete(Owner owner);
    void deleteById(Long id);
}
