package com.michaelyogar.tetra.app.base;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.core.GenericTypeResolver;

public abstract class BaseRepository<T> {
    private final EntityManager em;
    private final Class type;

    public BaseRepository(EntityManager em) {
        this.em = em;
        type = getClazz();
    }

    @Transactional
    public void save(T entity) {
        em.persist(entity);
    }

    public T findById(long id) {
        return em.find(getClazz(), id);
    }

    public T findBySmallestId() {
        String q = "select t from " + getClassName() + " t order by " + getPrimaryKeyName() + " limit 1";
        return em.createQuery(q, getClazz()).getSingleResult();
    }

    protected Class<T> getClazz() {
        return (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), BaseRepository.class);
    }

    protected String getPrimaryKeyName() {
        return type.getSimpleName().toLowerCase() + "_id";
    }

    protected String getClassName() {
        return type.getSimpleName();
    }
}
