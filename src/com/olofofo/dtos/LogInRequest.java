package com.olofofo.dtos;

import lombok.Data;

@Data
public class LogInRequest {
    private String userName;
    private String passWord;
}
