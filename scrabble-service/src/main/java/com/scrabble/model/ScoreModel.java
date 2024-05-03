package com.scrabble.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Setter
@Getter
public class ScoreModel {
    private String playerName;
    private String description;
    private Integer score;
}
