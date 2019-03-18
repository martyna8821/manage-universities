package pl.martyna.universities.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.martyna.universities.model.University;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class UniversityDAO  implements IUniversityDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<University> getAllUniversities() {

        return (List<University>) entityManager.createQuery("from University")
                .getResultList();
    }
}
