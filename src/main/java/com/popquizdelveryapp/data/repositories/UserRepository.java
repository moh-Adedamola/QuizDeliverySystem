package com.popquizdelveryapp.data.repositories;

import com.popquizdelveryapp.data.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

}
