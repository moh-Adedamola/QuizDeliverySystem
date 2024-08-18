package com.popquizdelveryapp.services;

import com.popquizdelveryapp.data.model.Question;
import com.popquizdelveryapp.data.model.User;
import com.popquizdelveryapp.data.model.UserAttempt;
import com.popquizdelveryapp.data.repositories.UserRepository;
import com.popquizdelveryapp.dtos.request.*;
import com.popquizdelveryapp.dtos.response.*;
import com.popquizdelveryapp.exception.UserAlreadyExistException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

public class UserServiceTest {

    @Autowired
     private  UserService userService;

    @Autowired
    private UserRepository userRepository;



//    @BeforeEach
//    public void setUp() {
//        userService.deleteAll();
//
//    }





    @Test
    public void testRegisterUser() {

        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setFirstName("adegbite");
        registerRequest.setLastName("mohammed");
        registerRequest.setPassword("password");
        registerRequest.setEmail("email@email.com");
        RegisterResponse response = userService.register(registerRequest);
        assertNotNull(response);
        assertThat(response.getMessage()).isEqualTo("Registration Successful");

    }

    @Test
    public void testThatEmailIsUniqueToOneUser(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setFirstName("adegbite");
        registerRequest.setLastName("mohammed");
        registerRequest.setEmail("myEmail@email.com");
        registerRequest.setPassword("password");
        RegisterResponse response = userService.register(registerRequest);
        assertNotNull(response);
        assertThat(response.getMessage()).isEqualTo("Registration Successful");;

        assertThrows(UserAlreadyExistException.class, ()->userService.register(registerRequest)) ;


    }

    @Test
    public void testToLoginUser() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setFirstName("ibrahim");
        registerRequest.setLastName("bolarinwa");
        registerRequest.setEmail("smudge@gmail.com");
        registerRequest.setPassword("1759");
        RegisterResponse response = userService.register(registerRequest);
        assertNotNull(response);
        assertThat(response.getMessage()).isEqualTo("Registration Successful");

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail("smudge@gmail.com");
        loginRequest.setPassword("1759");
        LoginResponse loginResponse = userService.login(loginRequest);
        assertNotNull(loginResponse);
        assertThat(loginResponse.getMessage()).isEqualTo("Login Successful");
    }

    @Test
    public void testThatUnregisteredUserCannotLogin(){
        UnregisteredUserLoginRequest unregisteredUserLoginRequest = new UnregisteredUserLoginRequest();
        unregisteredUserLoginRequest.setEmail("benson@gmail.com");
        unregisteredUserLoginRequest.setPassword("1759");
        UnregisteredUserLoginResponse unregisteredUserloginResponse = userService.unregisteredUserlogin(unregisteredUserLoginRequest);
        assertNotNull(unregisteredUserloginResponse);
        assertThat(unregisteredUserloginResponse.getMessage()).isEqualTo("User does not exist");



    }

    @Test
    public void testToFindUserByEmail() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setFirstName("moh");
        registerRequest.setLastName("crimson");
        registerRequest.setEmail("crimson@gmail.com");
        registerRequest.setPassword("12345");
        RegisterResponse response = userService.register(registerRequest);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Registration Successful");

        User foundUser = userService.findUserByEmail("crimson@gmail.com");
        assertNotNull(foundUser);

    }



    @Test
    public void testAttemptQuiz(){
        UserAttempt userAttempt1 = new UserAttempt();
        userAttempt1.setId("66c1384012b5340f11d11993");
        userAttempt1.setResponse("eight");

        UserAttempt userAttempt2 = new UserAttempt();
        userAttempt2.setId("66c1384012b5340f11d11993");
        userAttempt2.setResponse("void");

        List<UserAttempt> userAttempts = new ArrayList<UserAttempt>();
        userAttempts.add(userAttempt1);
        userAttempts.add(userAttempt2);
        String response = userService.attemptQuiz(userAttempts);
        assertThat(response).isEqualTo("You attempted " + userAttempts.size()
        + "\nYour score is " + "1/2");
    }



}