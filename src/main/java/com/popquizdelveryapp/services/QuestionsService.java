package com.popquizdelveryapp.services;

import com.popquizdelveryapp.data.model.Category;
import com.popquizdelveryapp.data.model.Difficulty;
import com.popquizdelveryapp.data.model.Question;
import com.popquizdelveryapp.dtos.request.AddQuestionRequest;
import com.popquizdelveryapp.dtos.response.AddQuestionResponse;

import java.util.List;

public interface QuestionsService {
    List<Question> findByCategory(Category category);

    AddQuestionResponse add(AddQuestionRequest addQuestionRequest);


    List<Question> findByDifficultyLevel(Difficulty difficultyLevel);

    List<Question> findQuestionById(String id);
}
