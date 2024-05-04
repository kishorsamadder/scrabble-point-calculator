package com.scrabble.service.impl;

import com.scrabble.entity.Score;
import com.scrabble.model.ScoreModel;
import com.scrabble.repository.ScoreRepository;
import com.scrabble.service.ScoreService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private ScoreRepository scoreRepository;

    @Override
    public Score saveScore(ScoreModel scoreModel) {

        return scoreRepository.save(modelMapper(scoreModel));
    }

    @Override
    public List<Score> getScore() {

        Page<Score> seatNumber = scoreRepository.findAll(
                PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "id")));

        return seatNumber.getContent();
    }

    private Score modelMapper(ScoreModel scoreModel) {
        return modelMapper.map(scoreModel, Score.class);
    }
}
