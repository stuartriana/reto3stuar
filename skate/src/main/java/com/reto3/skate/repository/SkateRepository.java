package com.reto3.skate.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reto3.skate.repository.crud.SkateCrudRepository;
import com.reto3.skate.model.Skate;

import java.util.List;
import java.util.Optional;


@Repository
public class SkateRepository {

    @Autowired
    private SkateCrudRepository skateCrudRepository;
    
    public List<Skate> getSkateAll(){
        return (List<Skate>) skateCrudRepository.findAll();
    }
    public Optional<Skate> getSkateId(Integer id){
        return skateCrudRepository.findById(id);
    }
    public Skate save(Skate skate){
        return skateCrudRepository.save(skate);
    }
    public void deleteSkate(Skate skate){
        skateCrudRepository.delete(skate);
    }

}
