package com.reto3.skate.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.reto3.skate.model.Admin;
import com.reto3.skate.services.AdminServices;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("api/Admin")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class AdminController {
    @Autowired  
    private AdminServices adminServices;

    @GetMapping("/all")
    public List<Admin> getAdminAll(){
        return adminServices.getAdminAll();
    }

    @GetMapping("/id")
    public Optional<Admin> getAdminId (@PathVariable("id")Integer id){
        return adminServices.getAdminId(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin saveAdmin (@RequestBody Admin admin){
        return adminServices.saveAdmin(admin);
    }
    
}
