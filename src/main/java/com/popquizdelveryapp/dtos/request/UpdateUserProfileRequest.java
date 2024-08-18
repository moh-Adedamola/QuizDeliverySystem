package com.popquizdelveryapp.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UpdateUserProfileRequest {
    private String firstName;
    private String lastName;
    private String password;
}
