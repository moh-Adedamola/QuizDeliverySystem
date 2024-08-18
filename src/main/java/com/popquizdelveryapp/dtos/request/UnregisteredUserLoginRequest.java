package com.popquizdelveryapp.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UnregisteredUserLoginRequest {
    private String email;
    private String password;
}
