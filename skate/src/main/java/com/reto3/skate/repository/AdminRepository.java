package com.reto3.skate.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reto3.skate.model.Admin;
import com.reto3.skate.repository.crud.AdminCrudRepository;

@Repository
public class AdminRepository {
    @Autowired
    private AdminCrudRepository adminCrudRepository;

    public List<Admin> getAdminAll(){
        return (List<Admin>) adminCrudRepository.findAll();
    }
    public Optional<Admin> getAdminId(Integer id){
        return adminCrudRepository.findById(id);
    }
    public Admin saveAdmin(Admin admin){
        return adminCrudRepository.save(admin);
    }
}
