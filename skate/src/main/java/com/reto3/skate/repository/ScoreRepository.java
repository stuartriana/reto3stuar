package com.reto3.skate.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reto3.skate.model.Score;
import com.reto3.skate.repository.crud.ScoreCrudRepository;

@Repository
public class ScoreRepository {
    
    @Autowired
    private ScoreCrudRepository scoreCrudRepository;

    public List<Score> getScoreAll(){
        return (List<Score>) scoreCrudRepository.findAll();
    }
    public Optional<Score> getScoreId(Integer id){
        return scoreCrudRepository.findById(id);
    }
    public Score saveScore(Score score){
        return scoreCrudRepository.save(score);
    }
}
