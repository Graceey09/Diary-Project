//package com.olofofo.data.repositories;
//
//import com.olofofo.data.models.Diary;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class DiaryRepositoryImpl implements DiaryRepository{
//    private List<Diary> diaries = new ArrayList<>();
//    @Override
//    public Diary save(Diary diary) {
//        if (diary.getId().equals(0)) newDiary(diary);
//        else update(diary);
//        return diary;
//    }
//
//    @Override
//    public Diary findById(int id) {
//        for (Diary diary : diaries) {
//            if (diary.== id) return diary;
//        }
//        return null;
//    }
//
//    private void newDiary(Diary diary) {
//        diary.setId(generateId());
//        diaries.add(diary);
//    }
//
//    private void update(Diary diary){
//        Diary updateDiary = findById(diary.getId());
//        updateDiary.setUserName(updateDiary.getUsername());
//    }
//    private String generateId() {
//        return diaries.size()+1;
//    }
//
//    @Override
//    public Diary findById(String id){
//        for (Diary diary : diaries){
//            if (diary.getId() == id)
//                return diary;
//        }
//        return null;
//    }
//
//    @Override
//    public void delete(String diary) {
//        diaries.remove(diary);
//
//    }
//
//
//    @Override
//    public Iterable<Diary> findAll() {
//        return null;
//    }
//
//    @Override
//    public int size() {
//        return diaries.size();
//    }
//    public long count() {
//        return diaries.size();
//    }
//    @Override
//    public void clear() {
//        diaries.clear();
//    }
//
//    @Override
//    public Diary findByUsername(String username) {
//        for(Diary diary: diaries)
//            if(diary.getUsername().equals(username))
//                return diary;
//        return null;
//    }
//}
