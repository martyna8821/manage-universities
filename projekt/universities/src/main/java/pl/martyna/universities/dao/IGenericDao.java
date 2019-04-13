package pl.martyna.universities.dao;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public interface IGenericDao<T extends Serializable> {

    void setClassT(Class< T > classToSet );

    T getById(final UUID id);

    List<T> getAll();

    void create(final T entity);

    void update(final T entity);

    void delete(final T entity);

    void deleteById(final UUID entityId);

}
