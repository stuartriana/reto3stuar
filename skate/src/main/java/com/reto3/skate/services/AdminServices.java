package com.reto3.skate.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reto3.skate.model.Admin;
import com.reto3.skate.repository.AdminRepository;

@Service
public class AdminServices {

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAdminAll(){
        return adminRepository.getAdminAll();
    }
    public Optional<Admin> getAdminId(Integer id){
        return adminRepository.getAdminId(id);
    }
    public Admin saveAdmin(Admin admin){
        if (admin.getIdAdmin()== null){
            return adminRepository.saveAdmin(admin);
        }else {
            Optional<Admin> admin1 = adminRepository.getAdminId(admin.getIdAdmin());
            if (admin1.isEmpty()){
                return adminRepository.saveAdmin(admin);
            }else {
                return admin;
            }
        }
    }
    
}
