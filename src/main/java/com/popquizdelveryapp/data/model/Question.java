package com.popquizdelveryapp.data.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;



@Getter
@Setter
public class Question {
    @Id

    private String id;
    private String questionText;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String correctAnswer;
    private String category;
    private Difficulty difficultyLevel;
    private LocalDateTime dateCreated = LocalDateTime.now();
}
