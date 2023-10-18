package com.olofofo.data.repositories;

import com.olofofo.data.models.Entry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EntryRepository extends MongoRepository<Entry, String> {
//    Entry save(Entry entry);
//    void delete(Entry entry);
//    Iterable<Entry> findAll();
//    void clear();
//
//    Entry findByUsername(String ownerName, String title);
//
//    Entry findById(int id);
//
//    long count();
}
