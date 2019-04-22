package pl.martyna.universities.dao;

import org.springframework.stereotype.Repository;
import pl.martyna.universities.model.Student;
import pl.martyna.universities.model.University;

import java.util.List;
import java.util.UUID;

@Repository
public class UniversityDao extends AbstractDao<University>
        implements IUniversityDao  {

    @Override
    public List<University> getUniversityStudents(UUID universityId) {
        String query = "SELECT U.students FROM University U where id = "
                + universityId.toString();
        return entityManager.createQuery(query).getResultList();
    }
}
