package com.olofofo.dtos;

import lombok.Data;

@Data
public class RegisterUserRequest {
    private String userName;
    private String passWord;
}
