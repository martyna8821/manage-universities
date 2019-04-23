package pl.martyna.universities.dao;

import org.springframework.stereotype.Repository;
import pl.martyna.universities.model.FieldOfStudy;
import pl.martyna.universities.model.Student;
import pl.martyna.universities.model.University;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Repository
public class UniversityDao extends AbstractDao<University>
        implements IUniversityDao  {

    @Override
    public Set<Student> getUniversityStudents(UUID universityId) {

        University foundUniversity = entityManager.find(University.class, universityId);
        return foundUniversity.getStudents();
    }

    @Override
    public List<FieldOfStudy> getUniversityFields(UUID universityId) {
        University foundUniversity = entityManager.find(University.class, universityId);
        return foundUniversity.getFieldsOfStudy();
    }
}
