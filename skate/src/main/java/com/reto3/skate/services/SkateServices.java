package com.reto3.skate.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.reto3.skate.repository.SkateRepository;
import com.reto3.skate.model.Skate;
import java.util.List;
import java.util.Optional;

@Service
public class SkateServices {

    @Autowired
    private SkateRepository skateRepository;
    
    public List<Skate> getSkateAll(){
        return skateRepository.getSkateAll();
    }

    public Optional<Skate> getSkateId(Integer id){
        return skateRepository.getSkateId(id);
    }

    public Skate save(Skate skate){
        if (skate.getId()==null){
            return skateRepository.save(skate);
        }
        else {
            Optional<Skate> skate1=skateRepository.getSkateId(skate.getId());
            if (skate1.isEmpty()){
                return skateRepository.save(skate);
            }
            else {
                return skate;
            }
        }
    }
    public Skate update(Skate skate){
        if (skate.getId()!= null){
            Optional<Skate> skate1 = skateRepository.getSkateId(skate.getId());
            if (!skate1.isEmpty()){
                if (skate.getName()!= null){
                    skate1.get().setName(skate.getName());
                }
                if (skate.getYear()!=  null){
                    skate1.get().setYear(skate.getYear());
                }
                if (skate.getBrand()!= null){
                    skate1.get().setBrand(skate.getBrand());
                }
                if (skate.getDescription()!= null){
                    skate1.get().setDescription(skate.getDescription());
                }
                if (skate.getCategory()!= null){
                    skate1.get().setCategory(skate.getCategory());
                }
                skateRepository.save(skate1.get());
                return skate1.get();
            } else {
                return skate;
            }
        } else {
            return skate;
        }
    }
    public boolean deleteSkate(Integer skateId) {
        boolean flag = false;
        Optional<Skate> skate1 = skateRepository.getSkateId(skateId);
        if (skate1.isPresent()){
            skateRepository.deleteSkate(skate1.get());
            flag = true;
        }
        return flag;
    } 
}
