package com.olofofo.services;

import com.olofofo.data.models.Diary;
import com.olofofo.dtos.LogInRequest;
import com.olofofo.dtos.RegisterUserRequest;

public interface DiaryServices {
    void register(RegisterUserRequest registerUserRequest);
    long count();
    Diary findByUsername(String username);
    void unlock(LogInRequest logInRequest);
    void lock(String username);

    void delete(String username, String password);
    Iterable<Diary> findAll();

    void addEntry(String userName, String title, String body);
}
