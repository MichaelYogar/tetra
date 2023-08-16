package com.michaelyogar.tetra.app.user;

import com.michaelyogar.tetra.app.base.BaseRepository;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository extends BaseRepository<User> {
    private final EntityManager entityManager;

    public UserRepository(EntityManager entityManager) {
        super(entityManager);
        this.entityManager = entityManager;
    }

    List<User> findAllUsers() {
        String q = "Select u from User u";
        return (List<User>) entityManager.createQuery(q).getResultList();
    }
}
