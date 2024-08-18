package com.popquizdelveryapp.services;

import com.popquizdelveryapp.data.model.Difficulty;
import com.popquizdelveryapp.data.model.User;
import com.popquizdelveryapp.data.model.UserAttempt;
import com.popquizdelveryapp.dtos.request.*;
import com.popquizdelveryapp.dtos.response.*;

import java.util.List;

public interface UserService {

    RegisterResponse register(RegisterRequest registerRequest);

    LoginResponse login(LoginRequest loginRequest);

    User findUserByEmail(String mail);

    void deleteAll();

    UnregisteredUserLoginResponse unregisteredUserlogin(UnregisteredUserLoginRequest unregisteredUserLoginRequest);

    List<QuizQuestion> startQuiz();

    String attemptQuiz(List<UserAttempt> attempts);
}
