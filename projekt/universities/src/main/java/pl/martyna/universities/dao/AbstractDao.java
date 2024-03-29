package pl.martyna.universities.dao;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Transactional
public abstract class AbstractDao<T extends Serializable> {

    private Class< T > classT;

    @PersistenceContext
    EntityManager entityManager;

    public void setClassT( Class< T > classToSet ) {
        this.classT = classToSet;
    }

    public T getById( UUID id ){
        return entityManager.find( classT, id );
    }
    public List< T > getAll(){
        return entityManager.createQuery( "from " + classT.getName() )
                .getResultList();
    }

    public void create( T entity ){
        entityManager.persist( entity );
    }

    public void update( T entity ){
        entityManager.merge( entity );
    }

    public void delete( T entity ){
        entityManager.remove( entity );
    }
    public void deleteById( UUID entityId ){
        T entity = getById( entityId );
        delete( entity );
    }
}
