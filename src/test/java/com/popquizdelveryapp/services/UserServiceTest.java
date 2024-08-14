package com.popquizdelveryapp.services;

import com.popquizdelveryapp.data.model.User;
import com.popquizdelveryapp.dtos.request.LoginRequest;
import com.popquizdelveryapp.dtos.request.RegisterRequest;
import com.popquizdelveryapp.dtos.response.LoginResponse;
import com.popquizdelveryapp.dtos.response.RegisterResponse;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

public class UserServiceTest {

    @Autowired
    UserService userService;


    @Test
    public void testRegisterUser() {

        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setFirstName("userFirstName");
        registerRequest.setLastName("userLastName");
        registerRequest.setPassword("password");
        registerRequest.setEmail("email@email.com");
        RegisterResponse response = userService.register(registerRequest);
        assertNotNull(response);
        assertThat(response.getMessage()).isEqualTo("Registration Successful");

    }

    @Test
    public void testToLoginUser() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setFirstName("userFirstName");
        registerRequest.setLastName("userLastName");
        registerRequest.setEmail("myEmail@gmail.com");
        registerRequest.setPassword("password");
        RegisterResponse response = userService.register(registerRequest);
        AssertionsForClassTypes.assertThat(response).isNotNull();
        AssertionsForClassTypes.assertThat(response.getMessage()).isEqualTo("Registration Successful");

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail("myEmail@gmail.com");
        loginRequest.setPassword("password");
        LoginResponse loginResponse = userService.login(loginRequest);
        assertNotNull(loginResponse);
        assertThat(loginResponse.getMessage()).isEqualTo("Login Successful");
    }

    @Test
    public void testToFindUserByEmail() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setFirstName("moh");
        registerRequest.setLastName("crimson");
        registerRequest.setEmail("crimson@gmail.com");
        registerRequest.setPassword("12345");
        RegisterResponse response = userService.register(registerRequest);
        AssertionsForClassTypes.assertThat(response).isNotNull();
        AssertionsForClassTypes.assertThat(response.getMessage()).isEqualTo("Registration Successful");

        User foundUser = userService.findUserByEmail("crimson@gmail.com");
        assertNotNull(foundUser);

    }





}