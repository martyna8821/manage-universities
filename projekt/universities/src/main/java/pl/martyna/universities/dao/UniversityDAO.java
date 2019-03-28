package pl.martyna.universities.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.martyna.universities.model.FieldOfStudy;
import pl.martyna.universities.model.University;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @Override
    public Optional<University> getUniversityById(UUID univesityId) {
        return Optional.ofNullable(
                entityManager.find(University.class, univesityId));
    }

    @Override
    public void addUniversity(University university) {
        entityManager.merge(university);
    }

    @Override
    public void updateUniversity(University university) {

    }

    @Override
    public void deleteUniversity(UUID univesityId) {

    }

    @Override
    public boolean universityExists(String name) {
        return false;
    }


}
