package me.fered.cactus.dao;

import javax.persistence.*;
import java.util.List;

abstract class BaseDao<T> {

    @PersistenceUnit(name = "cactus")
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("cactus");

    protected T create(T entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.flush();
        entityManager.refresh(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
        return entity;
    }

    protected T read(Class<T> entityClass, long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        T entity = entityManager.find(entityClass, id);
        if (entity != null) {
            entityManager.refresh(entity);
        }
        entityManager.close();
        return entity;
    }

    protected T update(T entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        T updatedEntity = entityManager.merge(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
        return updatedEntity;
    }

    protected void delete(T entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    protected List<T> readAll(Class<T> entityClass){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT a FROM " + entityClass.getSimpleName() + " a WHERE removed = 0");
        List<T> list = query.getResultList();
        return list;
    }

    protected long getCount(Class<T> entityClass){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT COUNT(*) FROM " + entityClass.getSimpleName() + " WHERE removed = 0");

        return (long) query.getSingleResult();
    }


}
