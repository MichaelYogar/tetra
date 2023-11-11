package com.michaelyogar.tetra.app.user;

import com.michaelyogar.tetra.app.base.BaseRepository;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository extends BaseRepository<User> {
    public UserRepository(EntityManager entityManager) {
        super(entityManager);
    }
}
