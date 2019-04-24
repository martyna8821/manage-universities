package pl.martyna.universities.dao;

import org.springframework.stereotype.Repository;
import pl.martyna.universities.exception.NotFoundException;
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
        if(foundUniversity == null){
            throw new NotFoundException("University not found");
        }
        else{
            return foundUniversity.getStudents();
        }

    }

    @Override
    public List<FieldOfStudy> getUniversityFields(UUID universityId) {
        University foundUniversity = entityManager.find(University.class, universityId);
        if(foundUniversity == null){
            throw new NotFoundException("University not Found");
        }
        else{
            return foundUniversity.getFieldsOfStudy();
        }
    }
}
