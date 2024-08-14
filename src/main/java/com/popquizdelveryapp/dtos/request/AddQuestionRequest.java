package com.popquizdelveryapp.dtos.request;

import com.popquizdelveryapp.data.model.Category;
import com.popquizdelveryapp.data.model.Difficulty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddQuestionRequest {
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private Category category;
    private String correctAnswer;
    private Difficulty difficultyLevel;
}
