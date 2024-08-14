package com.popquizdelveryapp.services;

import com.popquizdelveryapp.data.model.Question;
import com.popquizdelveryapp.data.repositories.QuestionsRepository;
import com.popquizdelveryapp.dtos.request.AddQuestionRequest;
import com.popquizdelveryapp.dtos.response.AddQuestionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionsServiceImpl implements QuestionsService {
    @Autowired
    private QuestionsRepository questionsRepository;

    @Override
    public AddQuestionResponse add(AddQuestionRequest addQuestionRequest) {
        Question question = new Question();
        question.setQuestionTitle(addQuestionRequest.getQuestionTitle());
        question.setCategory(addQuestionRequest.getCategory());
        question.setOption1(addQuestionRequest.getOption1());
        question.setOption2(addQuestionRequest.getOption2());
        question.setOption3(addQuestionRequest.getOption3());
        question.setOption4(addQuestionRequest.getOption4());
        question.setDifficultyLevel(addQuestionRequest.getDifficultyLevel());
        question.setCorrectAnswer(addQuestionRequest.getCorrectAnswer());
        questionsRepository.save(question);


        AddQuestionResponse addQuestionResponse = new AddQuestionResponse();
        addQuestionResponse.setMessage("Question added successfully");
        return addQuestionResponse;
    }
}
