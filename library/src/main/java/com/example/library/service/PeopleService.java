package com.example.library.service;

import com.example.library.model.PeopleEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class PeopleService {

    @PersistenceContext
    EntityManager entityManager;

    public List<PeopleEntity> getAllSql(){
        return entityManager.createNativeQuery("SELECT * from peopleentity").getResultList();
    }
    public List<PeopleEntity> getAllJpql(){
        return entityManager.createQuery("SELECT c FROM PeopleEntity c").getResultList();
    }
    public List<PeopleEntity> getAllAll(){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<PeopleEntity> criteriaQuery = criteriaBuilder.createQuery(PeopleEntity.class);
        Root<PeopleEntity> peopleEntityRoot = criteriaQuery.from(PeopleEntity.class);
        criteriaQuery.select(peopleEntityRoot);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
    public PeopleEntity create(PeopleEntity peopleEntity){
        return null;
    }

    @Transactional
    public void deleteSql(Long id){
//        entityManager.getTransaction().begin();
        Query query = entityManager.createNativeQuery("DELETE FROM peopleentity  WHERE id = :id");

        query.setParameter("id",id);
        int roo =query.executeUpdate();
//        entityManager.getTransaction().commit();

    }
    @Transactional
    public void deleteJPQL(Long id){
        entityManager.createQuery("DELETE FROM PeopleEntity p where p.id = : id").setParameter("id",id).executeUpdate();
    }
    @Transactional
    public void deleteManager(Long id){
        PeopleEntity peopleEntity = entityManager.find(PeopleEntity.class,id);

        entityManager.remove(peopleEntity);
    }




//    public PeopleEntity get(Long id){
//        return peopleRepo.getById(id);
//    }
//    public PeopleEntity create(PeopleEntity peopleEntity){
//        return peopleRepo.save(peopleEntity);
//    }
//    public void delete(Long id){
//        peopleRepo.deleteById(id);
//    }

}
