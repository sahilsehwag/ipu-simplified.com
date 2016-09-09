package org.ipunagri.services;

import org.hibernate.SessionFactory;
import org.ipunagri.models.IModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

import java.io.Serializable;
import java.util.Collection;


abstract class Dao<T extends IModel> implements IDao<T> {

    @Autowired
    protected HibernateTemplate hibernateTemplate;
    @Autowired
    protected SessionFactory sessionFactory;

    public Dao() {
    }

    @Override
    public void save(T object) {
        hibernateTemplate.save(object);
    }

    @Override
    public void update(T object) {
        hibernateTemplate.update(object);
    }

    @Override
    public void saveOrUpdate(T object) {
        hibernateTemplate.saveOrUpdate(object);
    }

    @Override
    public void get(Class modelClass, Serializable id) {
        hibernateTemplate.get(modelClass, id);
    }

    @Override
    public void delete(T object) {
        hibernateTemplate.delete(object);
    }

    @Override
    public void deleteAll(Collection<T> objects) {
        hibernateTemplate.deleteAll(objects);
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
