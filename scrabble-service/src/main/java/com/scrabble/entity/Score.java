package com.scrabble.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "score")
@Setter
@Getter
public class Score {
    public Score() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String playerName;

    @Column
    private String description;

    @Column(nullable = false)
    private Integer score;

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", playerName='" + playerName + '\'' +
                ", description='" + description + '\'' +
                ", score=" + score +
                '}';
    }
}
