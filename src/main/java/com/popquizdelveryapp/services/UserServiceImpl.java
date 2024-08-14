package com.popquizdelveryapp.services;

import com.popquizdelveryapp.data.model.User;
import com.popquizdelveryapp.data.repositories.UserRepository;
import com.popquizdelveryapp.dtos.request.LoginRequest;
import com.popquizdelveryapp.dtos.request.RegisterRequest;
import com.popquizdelveryapp.dtos.response.LoginResponse;
import com.popquizdelveryapp.dtos.response.RegisterResponse;
import com.popquizdelveryapp.exception.UserAlreadyExistException;
import com.popquizdelveryapp.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

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
                }
            }
        }
        throw new UserNotFoundException("User does not exist");
    }

    @Override
    public User findUserByEmail(String mail) {
        for (User user : userRepository.findAll()) {
            if (user.getEmail().equals(mail)){
                return user;
            }
        }

       throw new UserNotFoundException("User does not exist");
    }

    private void validateEmail(String email) {
        for (User user : userRepository.findAll()) {
            if (user.getEmail().equals(email)) {
                throw new UserAlreadyExistException("User same email already exist");
            }
        }
    }
}
