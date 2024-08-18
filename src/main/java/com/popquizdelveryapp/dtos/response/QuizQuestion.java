package com.popquizdelveryapp.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class QuizQuestion {
    private String id;
    private String questionText;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
}
