package com.popquizdelveryapp.services;


import com.popquizdelveryapp.data.model.Difficulty;
import com.popquizdelveryapp.data.model.Question;
import com.popquizdelveryapp.dtos.request.AddQuestionRequest;
import com.popquizdelveryapp.dtos.request.UpdateQuestionRequest;
import com.popquizdelveryapp.dtos.response.AddQuestionResponse;
import com.popquizdelveryapp.dtos.response.UpdateQuestionResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.popquizdelveryapp.data.model.Difficulty.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class QuestionServiceTest {

    @Autowired
    private QuestionsService questionsService;

    @Test
    public void testToAddQuestion(){

        AddQuestionRequest addQuestionRequest = new AddQuestionRequest();
        addQuestionRequest.setQuestionText(" 45. Which HTML element is used to put the JavaScript code?");
        addQuestionRequest.setDifficultyLevel(HARD);
        addQuestionRequest.setOption1("<javascript>");
        addQuestionRequest.setOption2("<js>");
        addQuestionRequest.setOption3("<scripting>");
        addQuestionRequest.setOption4("<script>");
        addQuestionRequest.setCorrectAnswer("<script>");
        addQuestionRequest.setCategory("JAVASCRIPT");
        AddQuestionResponse response = questionsService.add(addQuestionRequest);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Question added successfully");
    }

    @Test
    public void testToUpdateQuestion(){
        UpdateQuestionRequest updateQuestionRequest = new UpdateQuestionRequest();
        updateQuestionRequest.setQuestionText("45. Which Of The Following HTML element is used to put the JavaScript code?");
        UpdateQuestionResponse updateQuestionResponse = questionsService.updateQuestionById("66c145c0d71f313e84906f92", updateQuestionRequest);
        assertThat(updateQuestionResponse).isNotNull();
        assertThat(updateQuestionResponse.getMessage()).isEqualTo("Question updated successfully");

    }
//
//    @Test
//    public void testToFindQuestionByCategory(){
//        List<Question> foundQuestion = questionsService.findByCategory(Category.JAVA);
//        assertThat(foundQuestion).isNotNull();
//        assertThat(foundQuestion.size()).isEqualTo(15);
//    }
//
//    @Test
//    public void testToFindQuestionByDifficultyLevel() {
//        List<Question> foundQuestion = questionsService.findByDifficultyLevel(Difficulty.MEDIUM);
//        assertThat(foundQuestion).isNotNull();
//        assertThat(foundQuestion.size()).isEqualTo(15);
//
//    }
//
//    @Test
//    public void testToFindQuestionById() {
//        Question foundQuestion = questionsService.findQuestionById("66bc7a68eb17597ac93b35ac");
//        assertThat(foundQuestion).isNotNull();
//
//    }
//
//    @Test
//    public void testToDeleteQuestionById(){
//        Question foundQuestion = questionsService.findQuestionById("66c0b91baf92dc300f12b160");
//        assertThat(foundQuestion).isNotNull();
//        questionsService.deleteQuestionById("66c0b91baf92dc300f12b160");
//        Question deletedQuestion = questionsService.findQuestionById("66c0b91baf92dc300f12b160");
//        assertThat(deletedQuestion).isNull();
//
//    }
//

 

}

