package com.popquizdelveryapp.data.repositories;

import com.popquizdelveryapp.data.model.User;
import com.popquizdelveryapp.dtos.request.UpdateUserProfileRequest;
import com.popquizdelveryapp.dtos.response.UpdateUserProfileResponse;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<User, String> {

}
