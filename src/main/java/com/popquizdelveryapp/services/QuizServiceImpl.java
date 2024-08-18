package com.popquizdelveryapp.services;

import com.popquizdelveryapp.data.repositories.QuizRepository;
import com.popquizdelveryapp.dtos.response.AddQuestionToQuizResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuestionsService questionsService;

    @Autowired
    private QuizRepository quizRepository;

    @Override
    public AddQuestionToQuizResponse add(String category) {
        return null;
    }

//    @Override
//    public AddQuestionToQuizResponse add(String category) {
//        return null;
//    }
//
//    @Override
//    public AddQuestionToQuizResponse add(String category) {
//        return null;
//    }

//    @Override
//    public AddQuestionToQuizResponse add(Category category) {
//        List<Question> questionForQuiz = new ArrayList<>();
//        for (Question question : questionsService.findAll()){
//            if (question.getCategory().equals(category)){
//                questionForQuiz.add(question);
//            }
//        }
//        Quiz quiz = new Quiz();
//        quiz.setTitle(category.toString());
//        quiz.setQuestions(questionForQuiz);
//        quizRepository.save(quiz);
//
//        AddQuestionToQuizResponse addQuestionToQuizResponse = new AddQuestionToQuizResponse();
//        addQuestionToQuizResponse.setMessage("Quiz added successfully");
//        return addQuestionToQuizResponse;
//    }

}
