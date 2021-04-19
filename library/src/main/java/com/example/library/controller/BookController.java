package com.example.library.controller;

import com.example.library.model.BookEntity;
import com.example.library.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/book")
public class BookController {
    private BookService bookService;

    @GetMapping("/{id}")
    public BookEntity get(@PathVariable Long id){
        return bookService.getId(id);
    }
    @PostMapping("/post")
    public BookEntity create(@RequestBody BookEntity bookEntity){
        return bookService.create(bookEntity);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        bookService.delete(id);
    }
    @GetMapping
    public List<BookEntity> getAll(){
        return bookService.getAll();
    }

    @GetMapping("/post/{peopleId}/{bookId}")
    public String addPeople(@PathVariable Long bookId,@PathVariable Long peopleId){
        bookService.addPeople(bookId,peopleId);
        return "succes";
    }

}
