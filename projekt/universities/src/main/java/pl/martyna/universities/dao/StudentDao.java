package pl.martyna.universities.dao;

import org.springframework.stereotype.Repository;
import pl.martyna.universities.model.FieldOfStudy;
import pl.martyna.universities.model.Student;

import java.util.Set;
import java.util.UUID;

@Repository
public class StudentDao extends AbstractDao<Student>
        implements IStudentDao {
    @Override
    public Set<FieldOfStudy> getFieldsOfStudies(UUID studentId) {
       Student foundStudent = entityManager.find(Student.class, studentId);
         return foundStudent.getFieldsOfStudy();
    }
}
