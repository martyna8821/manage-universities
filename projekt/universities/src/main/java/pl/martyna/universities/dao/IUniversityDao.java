package pl.martyna.universities.dao;

import pl.martyna.universities.model.FieldOfStudy;
import pl.martyna.universities.model.Student;
import pl.martyna.universities.model.University;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface IUniversityDao  extends IGenericDao<University>{

    Set<Student> getUniversityStudents(UUID universityId);
    List<FieldOfStudy> getUniversityFields(UUID universityId);
}
