package com.popquizdelveryapp.data.repositories;

import com.popquizdelveryapp.data.model.Category;
import com.popquizdelveryapp.data.model.Difficulty;
import com.popquizdelveryapp.data.model.Question;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface QuestionsRepository extends MongoRepository<Question, String> {

    List<Question> findByCategory(Category category);

    List<Question> findByDifficultyLevel(Difficulty difficultyLevel);

    List<Question> findQuestionById(String id);


}
