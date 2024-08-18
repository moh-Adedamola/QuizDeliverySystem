package com.popquizdelveryapp.services;

import com.popquizdelveryapp.data.model.Difficulty;
import com.popquizdelveryapp.data.model.Question;
import com.popquizdelveryapp.dtos.request.AddQuestionRequest;
import com.popquizdelveryapp.dtos.request.UpdateQuestionRequest;
import com.popquizdelveryapp.dtos.response.AddQuestionResponse;
import com.popquizdelveryapp.dtos.response.QuestionDeleteResponse;
import com.popquizdelveryapp.dtos.response.UpdateQuestionResponse;

import java.util.List;

public interface QuestionsService {

    AddQuestionResponse add(AddQuestionRequest addQuestionRequest);

    List<Question> findByCategory(String category);

    List<Question> findByDifficultyLevel(Difficulty difficultyLevel);

    Question findQuestionById(String id);

    QuestionDeleteResponse deleteQuestionById(String id);

    List<Question> findAll();

    UpdateQuestionResponse updateQuestionById(String id,UpdateQuestionRequest updateQuestionRequest);
}
