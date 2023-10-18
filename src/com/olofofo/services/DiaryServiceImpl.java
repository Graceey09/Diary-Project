package com.olofofo.services;

import com.olofofo.data.models.Diary;
import com.olofofo.data.models.Entry;
import com.olofofo.data.repositories.DiaryRepository;
import com.olofofo.dtos.LogInRequest;
import com.olofofo.dtos.RegisterUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiaryServiceImpl implements DiaryServices{
    @Autowired
    private DiaryRepository diaryRepository;
    private EntryServices entryServices;
//    public void DiaryServicesImpl(){
//        diaryRepository = new DiaryRepositoryImpl();
//    }

    private Diary validate(String username){
        for (Diary diary : diaryRepository.findAll()) {
            if (diary.getUsername().equals(username)) {
                return diary;
            }
        }
        throw new IllegalArgumentException("Username already taken");
    }
    @Override
    public Diary findByUsername(String username){
        for (Diary diary : diaryRepository.findAll()){
            if (diary.getUsername().equals(username))
                return diary;
        }
        throw new IllegalArgumentException("Incorrect Username");
    }

    @Override
    public void unlock(LogInRequest logInRequest) {
        Diary diary = findByUsername(logInRequest.getUserName());
        if (diary.getPassword().equals(logInRequest.getPassWord())) diary.setLocked(false);
        else throw new IllegalArgumentException("Incorrect password");
        diaryRepository.save(diary);

    }

    @Override
    public void delete(String username, String password) {
        Diary diary = validate(username);
        removeDiary(password, diary);

    }

    @Override
    public Iterable<Diary> findAll() {
        return diaryRepository.findAll();
    }

    private void removeDiary(String password, Diary diary) {
        if (diary.getPassword().equals(password)){
            diaryRepository.delete(diary);
        }
    }


    @Override
    public void register(RegisterUserRequest registerUserRequest) {
        checkForUniqueUserName(registerUserRequest.getUserName());
        Diary diary = new Diary();
        diary.setUsername(registerUserRequest.getUserName());
        diary.setPassword(registerUserRequest.getPassWord());
        diaryRepository.save(diary);
    }

    private void checkForUniqueUserName(String userName) {
        for (Diary existName : diaryRepository.findAll()) {
            if (existName.getUsername().equals(userName)){
                throw new IllegalArgumentException("User name already exists");
            }
        }
    }

    @Override
    public long count() {
        return diaryRepository.count();
    }


    public void addEntry(String username, String title, String body) {
        validate(username);
        Entry entry =  entryServices.addEntry(username, title, body);
    }



    public void update(String username, String oldPassword, String newPassword) {
        Diary diary = findByUsername(username);
        if(diary.getPassword().equals(oldPassword)) diary.setPassword(newPassword);
        else throw new IllegalArgumentException("Invalid Credentials");
    }

    public Entry findEntry(String username, String title) {
        Entry entry = entryServices.findEntry(username, title);
        return entry;
    }

    public void lock(String username) {
        Diary foundDiary = findByUsername(username);
        foundDiary.setLocked(true);
        diaryRepository.save(foundDiary);
    }
}
