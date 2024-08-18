package com.popquizdelveryapp.services;

import com.popquizdelveryapp.data.model.Difficulty;
import com.popquizdelveryapp.data.model.Question;
import com.popquizdelveryapp.data.repositories.QuestionsRepository;
import com.popquizdelveryapp.dtos.request.AddQuestionRequest;
import com.popquizdelveryapp.dtos.request.UpdateQuestionRequest;
import com.popquizdelveryapp.dtos.response.AddQuestionResponse;
import com.popquizdelveryapp.dtos.response.QuestionDeleteResponse;
import com.popquizdelveryapp.dtos.response.UpdateQuestionResponse;
import com.popquizdelveryapp.dtos.response.UserDeleteResponse;
import com.popquizdelveryapp.exception.QuestionAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionsServiceImpl implements QuestionsService {

    @Autowired
    private QuestionsRepository questionsRepository;

    @Override
    public List<Question> findAll() {
        return questionsRepository.findAll();
    }

    @Override
    public UpdateQuestionResponse updateQuestionById(String id, UpdateQuestionRequest updateQuestionRequest) {
        Question question = questionsRepository.findQuestionById(id);
        if (updateQuestionRequest.getQuestionText() != null){
            question.setQuestionText(updateQuestionRequest.getQuestionText());
        }
        if (updateQuestionRequest.getOption1() != null) {
                question.setOption1(updateQuestionRequest.getOption1());
            }
        if (updateQuestionRequest.getOption2() != null) {
            question.setOption2(updateQuestionRequest.getOption2());
        }
        if (updateQuestionRequest.getOption3() != null) {
            question.setOption3(updateQuestionRequest.getOption3());
        }
        if (updateQuestionRequest.getOption4() != null) {
            question.setOption4(updateQuestionRequest.getOption4());
        }
        if (updateQuestionRequest.getCategory() !=null){
            question.setCategory(updateQuestionRequest.getCategory());
        }
        if (updateQuestionRequest.getCorrectAnswer() !=null){
            question.setCorrectAnswer(updateQuestionRequest.getCorrectAnswer());
        }
        if (updateQuestionRequest.getDateCreated() !=null){
            question.setDateCreated(updateQuestionRequest.getDateCreated());
        }
        questionsRepository.save(question);

        UpdateQuestionResponse updateQuestionResponse = new UpdateQuestionResponse();
        updateQuestionResponse.setMessage("Question updated successfully");
        return updateQuestionResponse;

    }





    @Override
    public List<Question> findByCategory(String category) {
        List<Question> questions = questionsRepository.findByCategory(category.toUpperCase());
        if (questions.isEmpty()) {
            throw new RuntimeException("No question found");
        }
        return questions;
    }

    @Override
    public AddQuestionResponse add(AddQuestionRequest addQuestionRequest) {
        validateQuestion(addQuestionRequest);
        Question question = new Question();
        question.setQuestionText(addQuestionRequest.getQuestionText().toLowerCase());
        question.setCategory(addQuestionRequest.getCategory());
        question.setOption1(addQuestionRequest.getOption1());
        question.setOption2(addQuestionRequest.getOption2());
        question.setOption3(addQuestionRequest.getOption3());
        question.setOption4(addQuestionRequest.getOption4());
        question.setDifficultyLevel(addQuestionRequest.getDifficultyLevel());
        question.setCorrectAnswer(addQuestionRequest.getCorrectAnswer().toLowerCase());
        questionsRepository.save(question);

        AddQuestionResponse addQuestionResponse = new AddQuestionResponse();
        addQuestionResponse.setMessage("Question added successfully");
        return addQuestionResponse;
    }

    public void validateQuestion(AddQuestionRequest addQuestionRequest) {
        String questionTitle = addQuestionRequest.getQuestionText().toLowerCase();
        String correctAnswer = addQuestionRequest.getCorrectAnswer().toLowerCase();

        for (Question question : questionsRepository.findAll()){
            if (question.getQuestionText().equals(questionTitle) &&
                    question.getCorrectAnswer().equals(correctAnswer)){
                throw new QuestionAlreadyExistException("Question already exists");
            }
        }

    }

    @Override
    public List<Question> findByDifficultyLevel(Difficulty difficultyLevel) {
        return questionsRepository.findByDifficultyLevel(difficultyLevel);
    }

    @Override
    public Question findQuestionById(String id) {
        Question question = questionsRepository.findQuestionById(id);
        if (question == null) {
            throw new RuntimeException("Question not found");
        }
        return question;
    }

    @Override
    public QuestionDeleteResponse deleteQuestionById(String id) {

        for (Question question : questionsRepository.findAll()){
            if (question.getId().equals(id)){
                questionsRepository.delete(question);
                QuestionDeleteResponse questionDeleteResponse = new QuestionDeleteResponse();
                questionDeleteResponse.setMessage("Question deleted successfully");
                return questionDeleteResponse;
            }

        }

        throw new RuntimeException("Question does not exist");
    }

}


