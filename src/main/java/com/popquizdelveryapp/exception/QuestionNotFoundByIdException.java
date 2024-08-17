package com.popquizdelveryapp.exception;

public class QuestionNotFoundByIdException extends RuntimeException {
    public QuestionNotFoundByIdException(String message) {
        super(message);

    }
}
