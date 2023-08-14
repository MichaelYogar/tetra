package com.michaelyogar.tetra.repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

public abstract class BaseRepository<T> {
    private final EntityManager em;

    public BaseRepository(EntityManager em) {
        this.em = em;
    }

    @Transactional
    public void save(T entity) {
        em.persist(entity);
    }

    public T findById(Class<T> clazz, long id) {
        return em.find(clazz, id);
    }

}
