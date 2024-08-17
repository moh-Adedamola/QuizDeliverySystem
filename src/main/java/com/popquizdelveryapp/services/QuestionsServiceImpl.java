package com.popquizdelveryapp.services;

import com.popquizdelveryapp.data.model.Category;
import com.popquizdelveryapp.data.model.Difficulty;
import com.popquizdelveryapp.data.model.Question;
import com.popquizdelveryapp.data.repositories.QuestionsRepository;
import com.popquizdelveryapp.dtos.request.AddQuestionRequest;
import com.popquizdelveryapp.dtos.response.AddQuestionResponse;
import com.popquizdelveryapp.exception.QuestionNotFoundByIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionsServiceImpl implements QuestionsService {
    @Autowired
    private QuestionsRepository questionsRepository;


    @Override
    public List<Question> findByCategory(Category category) {
        return questionsRepository.findByCategory(category);
    }

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

    @Override
    public List<Question> findByDifficultyLevel(Difficulty difficultyLevel) {
        return questionsRepository.findByDifficultyLevel(difficultyLevel);
    }

    @Override
    public List<Question> findQuestionById(String id) {
        return questionsRepository.findQuestionById(id);
    }
}
