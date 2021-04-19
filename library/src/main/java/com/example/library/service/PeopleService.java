package com.example.library.service;

import com.example.library.model.BookEntity;
import com.example.library.model.PeopleEntity;
import com.example.library.repository.BookRepo;
import com.example.library.repository.PeopleRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PeopleService {
    private PeopleRepo peopleRepo;
    private BookRepo bookRepo;

    public PeopleEntity get(Long id){
        return peopleRepo.getById(id);
    }
    public PeopleEntity create(PeopleEntity peopleEntity){
        return peopleRepo.save(peopleEntity);
    }
    public void delete(Long id){
        peopleRepo.deleteById(id);
    }
    public List<PeopleEntity> getAll(){
        return peopleRepo.getAllBy();
    }

    public void addBook(Long peopleId, Long bookId){
        PeopleEntity peopleEntity = peopleRepo.getById(peopleId);
        BookEntity bookEntity = bookRepo.getById(bookId);
        peopleEntity.setBook(bookEntity);
        bookEntity.setPeople(peopleEntity);
        peopleRepo.save(peopleEntity);
    }

    public BookEntity addBook2(BookEntity bookEntity, Long peopleId) {
        PeopleEntity peopleEntity = peopleRepo.getById(peopleId);
        bookEntity.setPeople(peopleEntity);
        return bookRepo.save(bookEntity);
    }
}
