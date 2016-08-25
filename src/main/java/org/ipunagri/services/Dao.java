package org.ipunagri.services;

import org.hibernate.SessionFactory;
import org.ipunagri.models.IModel;
import org.springframework.orm.hibernate4.HibernateTemplate;

import java.io.Serializable;
import java.util.Collection;


abstract class Dao<T extends IModel> implements IDao<T>{

    protected HibernateTemplate hibernateTemplate;
    protected SessionFactory sessionFactory;

    public Dao(){}

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

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
        hibernateTemplate = new HibernateTemplate(this.sessionFactory);
    }

}
