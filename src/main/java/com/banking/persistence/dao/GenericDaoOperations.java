package com.banking.persistence.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("genericDaoOperations")
@Transactional
public class GenericDaoOperations<T> {

    private static final Logger LOGGER  = LoggerFactory.getLogger(GenericDaoOperations.class);
    private Class<T> entity;
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected final Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void save(final T entity) {
        getCurrentSession().saveOrUpdate(entity);
        LOGGER.info("DB - Save Completed");
    }

    public void update(final T entity) {
        getCurrentSession().merge(entity);
        LOGGER.info("DB - Update Completed");
    }

    public void delete(final T entity) {
        getCurrentSession().delete(entity);
        LOGGER.info("DB - Delete Completed");
    }








}
