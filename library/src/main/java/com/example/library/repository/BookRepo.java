package com.example.library.repository;

import com.example.library.model.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepo extends JpaRepository<BookEntity, Long> {
    public BookEntity getById(Long id);
    public List<BookEntity> getAllBy();
}
