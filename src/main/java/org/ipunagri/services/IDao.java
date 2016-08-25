package org.ipunagri.services;



import org.ipunagri.models.IModel;

import java.io.Serializable;
import java.util.Collection;


public interface IDao<T extends IModel> {

    public void save(T object);
    public void update(T object);
    public void saveOrUpdate(T object);
    public void get(Class modelClass, Serializable id);
    public void delete(T user);
    public void deleteAll(Collection<T> objects);

}
