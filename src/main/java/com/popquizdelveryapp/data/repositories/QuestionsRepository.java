package com.popquizdelveryapp.data.repositories;

import com.popquizdelveryapp.data.model.Question;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuestionsRepository extends MongoRepository<Question, String> {
}
