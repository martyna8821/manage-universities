package pl.martyna.universities.dao;

import pl.martyna.universities.model.FieldOfStudy;
import pl.martyna.universities.model.Student;

import java.util.Set;
import java.util.UUID;

public interface IStudentDao extends IGenericDao<Student>{

    Set<FieldOfStudy> getFieldsOfStudies(UUID studentId);
}
