package com.example.library.repository;

import com.example.library.model.PeopleEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PeopleRepo extends CrudRepository<PeopleEntity, Long> , JpaSpecificationExecutor<PeopleEntity> {
    public PeopleEntity getById(Long id);
    public List<PeopleEntity> getAllBy();
}
