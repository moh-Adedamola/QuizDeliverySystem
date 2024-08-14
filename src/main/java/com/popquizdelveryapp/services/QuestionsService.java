package com.popquizdelveryapp.services;

import com.popquizdelveryapp.dtos.request.AddQuestionRequest;
import com.popquizdelveryapp.dtos.response.AddQuestionResponse;

public interface QuestionsService {
    AddQuestionResponse add(AddQuestionRequest addQuestionRequest);


}
