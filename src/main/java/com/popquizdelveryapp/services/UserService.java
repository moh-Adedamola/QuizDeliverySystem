package com.popquizdelveryapp.services;

import com.popquizdelveryapp.data.model.User;
import com.popquizdelveryapp.dtos.request.LoginRequest;
import com.popquizdelveryapp.dtos.request.RegisterRequest;
import com.popquizdelveryapp.dtos.response.LoginResponse;
import com.popquizdelveryapp.dtos.response.RegisterResponse;

public interface UserService {

    RegisterResponse register(RegisterRequest registerRequest);

    LoginResponse login(LoginRequest loginRequest);

    User findUserByEmail(String mail);
}
