package com.olofofo.data.repositories;

import com.olofofo.data.models.Diary;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DiaryRepository extends MongoRepository<Diary, String> {

//    Diary save(Diary diary);
//    Diary findById(int id);
//    void delete(String diary);
//    Iterable<Diary> findAll();
//    int size();
//    void clear();
//
//
//    Diary findByUsername(String username);
}
