package com.scrabble.controller;

import com.scrabble.entity.Score;
import com.scrabble.model.ScoreModel;
import com.scrabble.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/score")
@CrossOrigin("*")
public class ScrabbleController {

    @Autowired
    ScoreService scoreService;

    @PostMapping
    public ResponseEntity<Score> saveScore(@RequestBody ScoreModel score){
        try{
            return new ResponseEntity<>(scoreService.saveScore(score), HttpStatus.OK);
        } catch (Exception e)
        {
            throw e;
        }
    }

    @GetMapping
    public ResponseEntity<List<Score>> getScore(){
        try{
            return new ResponseEntity<>(scoreService.getScore(), HttpStatus.OK);
        } catch (Exception e) {
            throw e;
        }

    }
}
