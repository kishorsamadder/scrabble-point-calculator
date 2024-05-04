package com.scrabble.service.impl;

import com.scrabble.entity.Score;
import com.scrabble.model.ScoreModel;
import com.scrabble.repository.ScoreRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ScoreServiceImplTest {

    @Mock
    private ScoreRepository scoreRepository;
    @Mock
    private ModelMapper modelMapper;

    @Autowired
    private ScoreServiceImpl scoreService;

    @Test
    void getScoreList() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "id"));

        when(scoreRepository.findAll(pageable)).thenReturn(prepareScoreListRes());

        assertEquals(1, scoreService.getScore().size());
    }

    @Test
    void saveScore() {
        when(modelMapper.map(prepareScodeModel(), Score.class)).thenReturn(mockScore());
        when(scoreRepository.save(mockScore())).thenReturn(mockScore());

        assertEquals(mockScore().getScore(), scoreService.saveScore(prepareScodeModel()).getScore());
    }

    private ScoreModel prepareScodeModel() {
        return ScoreModel.builder()
                .description("description")
                .score(10)
                .playerName("player")
                .build();

    }

    private Score mockScore() {
        Score score = new Score();
        score.setScore(10);
        score.setId(1l);
        score.setDescription("description");
        score.setPlayerName("player");

        return score;
    }

    private Page<Score> prepareScoreListRes() {
        List<Score> sList = new ArrayList<>();

        sList.add(mockScore());
        return new PageImpl<>(sList);
    }

}
