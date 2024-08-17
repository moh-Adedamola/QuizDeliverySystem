package com.popquizdelveryapp.services;


import com.popquizdelveryapp.data.model.Category;
import com.popquizdelveryapp.data.model.Difficulty;
import com.popquizdelveryapp.data.model.Question;
import com.popquizdelveryapp.data.repositories.QuestionsRepository;
import com.popquizdelveryapp.dtos.request.AddQuestionRequest;
import com.popquizdelveryapp.dtos.response.AddQuestionResponse;
import com.popquizdelveryapp.exception.QuestionNotFoundByIdException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.popquizdelveryapp.data.model.Category.*;
import static com.popquizdelveryapp.data.model.Difficulty.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class QuestionServiceTest {

    @Autowired
    private QuestionsService questionsService;
    @Autowired
    private QuestionsRepository questionsRepository;





    @Test
    public void testToAddQuestion(){

        AddQuestionRequest addQuestionRequest = new AddQuestionRequest();
        addQuestionRequest.setQuestionTitle(" 45. Which HTML element is used to put the JavaScript code?");
        addQuestionRequest.setDifficultyLevel(HARD);
        addQuestionRequest.setOption1("<javascript>");
        addQuestionRequest.setOption2("<js>");
        addQuestionRequest.setOption3("<scripting>");
        addQuestionRequest.setOption4("<script>");
        addQuestionRequest.setCorrectAnswer("<script>");
        addQuestionRequest.setCategory(JAVASCRIPT);
        AddQuestionResponse response = questionsService.add(addQuestionRequest);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Question added successfully");
    }

    @Test
    public void testToFindQuestionByCategory(){
        List<Question> foundQuestion = questionsService.findByCategory(Category.JAVA);
        assertThat(foundQuestion).isNotNull();
        assertThat(foundQuestion.size()).isEqualTo(15);



    }

    @Test
    public void testToFindQuestionByDifficultyLevel() {
        List<Question> foundQuestion = questionsService.findByDifficultyLevel(Difficulty.MEDIUM);
        assertThat(foundQuestion).isNotNull();
        assertThat(foundQuestion.size()).isEqualTo(15);

    }

    @Test
    public void testToFindQuestionById() {
        List<Question> foundQuestion = questionsService.findQuestionById("66bc7a68eb17597ac93b35ac");
        assertThat(foundQuestion).isNotNull();
        assertThrows(QuestionNotFoundByIdException.class, ()->questionsService.findQuestionById("Question not found"));



    }
 

}

