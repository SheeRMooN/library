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
public class BookService {
    private BookRepo bookRepo;
    private PeopleRepo peopleRepo;

    public BookEntity getId(Long id) {
        return bookRepo.getById(id);
    }

    public BookEntity create(BookEntity bookEntity) {
        return bookRepo.save(bookEntity);
    }

    public void delete(Long id) {
        bookRepo.deleteById(id);
    }

    public List<BookEntity> getAll() {
        return bookRepo.getAllBy();
    }

    public void addPeople(Long bookId, Long peopleId) {
        PeopleEntity peopleEntity = peopleRepo.getById(peopleId);
        BookEntity bookEntity = bookRepo.getById(bookId);
        peopleEntity.setBook(bookEntity);
        bookEntity.setPeople(peopleEntity);
        peopleRepo.save(peopleEntity);
    }
}
