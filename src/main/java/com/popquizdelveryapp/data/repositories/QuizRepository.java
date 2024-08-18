package com.popquizdelveryapp.data.repositories;

import com.popquizdelveryapp.data.model.Quiz;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuizRepository extends MongoRepository<Quiz, String> {
}
