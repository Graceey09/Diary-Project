package com.olofofo.controllers;

import com.olofofo.data.models.Diary;
import com.olofofo.dtos.LogInRequest;
import com.olofofo.dtos.RegisterUserRequest;
import org.springframework.web.bind.annotation.*;
import com.olofofo.services.DiaryServiceImpl;
import com.olofofo.services.DiaryServices;


@RestController
public class DiaryControllers {
    private DiaryServices diaryService = new DiaryServiceImpl();

    @PostMapping("/register")
    public String register(RegisterUserRequest registerUserRequest){
        diaryService.register(registerUserRequest);
        return "Successful";
    }

    @PatchMapping("/unlock")
    public String unlock(LogInRequest logInRequest){
        diaryService.unlock(logInRequest);
        return "Unlocked";
    }

    @PostMapping("/createNewEntry")
    public String createEntry(String userName, String title, String body){
        diaryService.addEntry(userName, title, body);
        return "Entry Created";
    }

    @GetMapping("/findDiary")
    public Diary findDiary(String userName){
        return diaryService.findByUsername(userName);
    }

    @DeleteMapping("/delete")
    public void delete(String userName, String password) {
        diaryService.delete(userName, password);
    }

    @PatchMapping("/lock")
    public String lock(String username) {
        diaryService.lock(username);
        return"Locked";
}
}
