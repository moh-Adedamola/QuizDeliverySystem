package com.popquizdelveryapp.exception;

public class QuestionAlreadyExistException extends RuntimeException {

    public QuestionAlreadyExistException(String message) {

        super(message);
    }
}
