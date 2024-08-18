package com.popquizdelveryapp.controller;

import com.popquizdelveryapp.data.model.UserAttempt;
import com.popquizdelveryapp.dtos.request.LoginRequest;
import com.popquizdelveryapp.dtos.request.RegisterRequest;
import com.popquizdelveryapp.dtos.response.ApiResponse;
import com.popquizdelveryapp.dtos.response.LoginResponse;
import com.popquizdelveryapp.dtos.response.QuizQuestion;
import com.popquizdelveryapp.dtos.response.RegisterResponse;
import com.popquizdelveryapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest registerRequest) {
        try{
            RegisterResponse response = userService.register(registerRequest);
            return new ResponseEntity<>(new ApiResponse(true, response), HttpStatus.CREATED);
        } catch (Exception exception){
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), HttpStatus.BAD_REQUEST);
        }


    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        try{
            LoginResponse response = userService.login(loginRequest);
            return new ResponseEntity<>(new ApiResponse(true, response), HttpStatus.CREATED);
        } catch (Exception exception){
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/startQuiz")
    public ResponseEntity<?> startQuiz() {
        try{
            return new ResponseEntity<>(new ApiResponse(true, userService.startQuiz()), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/attemptQuiz")
    public String attemptQuiz(@RequestBody List<UserAttempt> attempts ) {
        try{
            return userService.attemptQuiz(attempts);
        } catch (Exception e){
            return e.getMessage();
        }
    }

}
