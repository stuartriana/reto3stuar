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
}
