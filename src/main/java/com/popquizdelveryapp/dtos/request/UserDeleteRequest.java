package com.popquizdelveryapp.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UserDeleteRequest {
    private String email;
    private String password;

}
