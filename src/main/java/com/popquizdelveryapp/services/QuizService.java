package com.popquizdelveryapp.services;

import com.popquizdelveryapp.dtos.response.AddQuestionToQuizResponse;

public interface QuizService {

    AddQuestionToQuizResponse add(String category);


}
