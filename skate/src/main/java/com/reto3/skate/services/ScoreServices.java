package com.reto3.skate.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reto3.skate.model.Score;
import com.reto3.skate.repository.ScoreRepository;



@Service
public class ScoreServices {

    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getScoreAll(){
        return scoreRepository.getScoreAll();
    }
    public Optional<Score> getScoreId(Integer id){
        return scoreRepository.getScoreId(id);
    }
    public Score saveScore (Score score){
        if (score.getIdScore()== null){
            return scoreRepository.saveScore(score);
        }else {
            Optional<Score> score1 = scoreRepository.getScoreId(score.getIdScore());
            if (score1.isEmpty()){
                return scoreRepository.saveScore(score);
            }else {
                return score;
            }
        }
    }   
}
