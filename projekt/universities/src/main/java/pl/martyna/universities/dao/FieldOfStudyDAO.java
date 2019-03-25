package pl.martyna.universities.dao;

import org.springframework.stereotype.Repository;
import pl.martyna.universities.model.FieldOfStudy;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class FieldOfStudyDAO implements IFieldOfStudyDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<FieldOfStudy> getAllFieldsOfStudy() {
        return entityManager.createQuery("from FieldOfStudy")
                .getResultList();
    }
}
