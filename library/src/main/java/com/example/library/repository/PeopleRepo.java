package com.example.library.repository;

import com.example.library.model.PeopleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PeopleRepo extends JpaRepository<PeopleEntity, Long> {
    public PeopleEntity getById(Long id);
    public List<PeopleEntity> getAllBy();
}
