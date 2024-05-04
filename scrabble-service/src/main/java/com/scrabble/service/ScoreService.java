package com.scrabble.service;

import com.scrabble.entity.Score;
import com.scrabble.model.ScoreModel;

import java.util.List;

public interface ScoreService {
    public Score saveScore(ScoreModel scoreModel);
    List<Score> getScore();
}
