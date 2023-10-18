package com.olofofo.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Diary {

    @Id
    private String id;
    private String userName;
    private String password;

    public void setUsername(String username) {
    }

    public void setLocked(boolean b) {
    }

    public Object getUsername() {
        return null;
    }

    public void setUserName(Object username) {
    }
}
