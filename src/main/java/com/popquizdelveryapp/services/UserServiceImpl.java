package com.popquizdelveryapp.services;

import com.popquizdelveryapp.data.model.Question;
import com.popquizdelveryapp.data.model.User;
import com.popquizdelveryapp.data.model.UserAttempt;
import com.popquizdelveryapp.data.repositories.UserRepository;
import com.popquizdelveryapp.dtos.request.*;
import com.popquizdelveryapp.dtos.response.*;
import com.popquizdelveryapp.exception.UserAlreadyExistException;
import com.popquizdelveryapp.exception.UserNotFoundException;
import com.popquizdelveryapp.exception.UsernameOrPasswordException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QuestionsService questionsService;

    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {
        validateEmail(registerRequest.getEmail());
        User newUser = new User();
        newUser.setFirstName(registerRequest.getFirstName());
        newUser.setLastName(registerRequest.getLastName());
        newUser.setEmail(registerRequest.getEmail());
        newUser.setPassword(registerRequest.getPassword());
        userRepository.save(newUser);
        RegisterResponse registerResponse = new RegisterResponse();
        registerResponse.setMessage("Registration Successful");
        return registerResponse;

    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        for (User user : userRepository.findAll()) {
            if (user.getEmail().equals(email)){
                if (user.getPassword().equals(password)){
                    user.setLogin(true);
                    userRepository.save(user);
                    LoginResponse loginResponse = new LoginResponse();
                    loginResponse.setMessage("Login Successful");
                    return loginResponse;
                } else {
                    throw new UsernameOrPasswordException("Invalid username or password");
                }
            }
        }
        throw new UserNotFoundException("User does not exist");
    }



    @Override
    public User findUserByEmail(String email) {
        for (User user : userRepository.findAll()) {
            if (user.getEmail().equals(email)){
                return user;
            }
        }

       throw new UserNotFoundException("User does not exist");
    }



    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

    @Override
    public UnregisteredUserLoginResponse unregisteredUserlogin(UnregisteredUserLoginRequest unregisteredUserLoginRequest) {
        String email = unregisteredUserLoginRequest.getEmail();
        String password = unregisteredUserLoginRequest.getPassword();

        for (User user : userRepository.findAll()) {
            if (!user.getEmail().equals(email)) {
                if (!user.getPassword().equals(password)) {
                    user.setLogin(false);
                    userRepository.save(user);
                    UnregisteredUserLoginResponse unregisteredUserLoginResponse = new UnregisteredUserLoginResponse();
                    unregisteredUserLoginResponse.setMessage("User does not exist");
                    return unregisteredUserLoginResponse;
                }
            }
        }
        return null;
    }



    @Override
    public List<QuizQuestion> startQuiz() {
        List<Question> allQuestion = questionsService.findAll();
        List<QuizQuestion> quizQuestions = new ArrayList<>();

        for (Question question : allQuestion) {
            QuizQuestion quizQuestion = new QuizQuestion();
            quizQuestion.setId(question.getId());
            quizQuestion.setQuestionText(question.getQuestionText());
            quizQuestion.setOption1(question.getOption1());
            quizQuestion.setOption2(question.getOption2());
            quizQuestion.setOption3(question.getOption3());
            quizQuestion.setOption4(question.getOption4());
            quizQuestions.add(quizQuestion);
        }
        return quizQuestions;
    }

    @Override
    public String attemptQuiz(List<UserAttempt> attempts) {

        int answerCount = 0;
        for (UserAttempt attempt : attempts) {
            Question question = questionsService.findQuestionById(attempt.getId());
            if (attempt.getResponse() != null && attempt.getResponse().equals(question.getCorrectAnswer())){
                answerCount++;
            }
        }

            return "You attempted " + attempts.size() +
                    "\nYour score is " + answerCount + "/" + attempts.size();
    }



    private void validateEmail(String email) {
        for (User user : userRepository.findAll()) {
            if (user.getEmail().equals(email)) {
                throw new UserAlreadyExistException("User with same email already exist");
            }
        }
    }


}
