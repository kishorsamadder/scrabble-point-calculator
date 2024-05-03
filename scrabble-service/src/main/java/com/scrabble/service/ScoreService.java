package com.scrabble.service;

import com.scrabble.entity.Score;
import com.scrabble.model.ScoreModel;
import com.scrabble.service.impl.ScoreServiceImpl;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ScoreService {
    public Score saveScore(ScoreModel scoreModel);
    List<Score> getScore();
}
