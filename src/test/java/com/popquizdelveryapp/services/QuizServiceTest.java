package com.popquizdelveryapp.services;

import com.popquizdelveryapp.dtos.response.AddQuestionToQuizResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class QuizServiceTest {

    @Autowired
    private QuizService quizService;

//    @Test
//    public void addQuestionToServiceTest(){
//        AddQuestionToQuizResponse addQuestionToQuizResponse = quizService.add(Category.JAVA);
//        assertThat(addQuestionToQuizResponse).isNotNull();
//    }

}
