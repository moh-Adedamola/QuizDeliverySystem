package com.popquizdelveryapp.data.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter

public class Quiz {
    @Id

    private String id;
    private String title;
    private String description;
    private List<Question> questions;
    private LocalDateTime dateCreated;

}
