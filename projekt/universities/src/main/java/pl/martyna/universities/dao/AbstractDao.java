package pl.martyna.universities.dao;

import net.bytebuddy.asm.Advice;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import pl.martyna.universities.model.University;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public abstract class AbstractDao<T extends Serializable> {

    private Class<T> classT;

    @PersistenceContext
    private EntityManager entityManager;


    public final void setClassT( Class< T > classToSet ){
        this.classT = classToSet;
    }

    public T findById( UUID id ){
        return entityManager.find(classT, id);

    }
    public List< T > findAll(){
        String query = "from "+ classT.getName();
        System.out.println(query);
        return (List<T>) entityManager.createQuery(query).getResultList();

    }

    public String getClassName(){
        return "from "+ classT.getName();

    }
    public void create( T entity ){
       getCurrentSession().persist( entity );
    }

    public void update( T entity ){
        getCurrentSession().merge( entity );
    }

    public void delete( T entity ){
        getCurrentSession().delete( entity );
    }

    public void deleteById( UUID entityId ) {
        T entity = findById( entityId );
        delete( entity );
    }

    protected final Session getCurrentSession() {

        SessionFactory sessionFactory = entityManager.unwrap(SessionFactory.class);
       return sessionFactory.getCurrentSession();
    }
}
