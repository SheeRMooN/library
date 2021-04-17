package com.example.library.controller;

import com.example.library.model.PeopleEntity;
import com.example.library.service.BookService;
import com.example.library.service.PeopleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/people")
public class PeopleController {
    private PeopleService peopleService;
    private BookService bookService;

    @GetMapping("/{id}")
    public PeopleEntity get(@PathVariable Long id){
        return peopleService.get(id);
    }
    @GetMapping
    public List<PeopleEntity> getAll(){
        return peopleService.getAll();
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        peopleService.delete(id);
        return "succes";
    }
    @PostMapping("/post")
    public PeopleEntity create(@RequestBody PeopleEntity peopleEntity){
        return peopleService.create(peopleEntity);
    }


    @GetMapping("/post/{peopleId}/{bookId}")
    public String addBook(@PathVariable Long peopleId,@PathVariable Long bookId){
        peopleService.addBook(peopleId,bookId);
        return "succes";
    }
}
