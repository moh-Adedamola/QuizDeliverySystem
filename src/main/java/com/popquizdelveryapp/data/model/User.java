package com.popquizdelveryapp.data.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter

@Document("QuizAppUsers")
public class User {
    @Id

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private LocalDateTime dateCreated;
    private boolean isLogin;
    private List<Question> questionAnswered;

}
