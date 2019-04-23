package pl.martyna.universities.service;

import pl.martyna.universities.model.FieldOfStudy;
import pl.martyna.universities.model.Student;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface IStudentService {
    Optional<Student> getStudentById(UUID studentId);
    List<Student> getAllStudents();
    void createStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(Student student);
    void deleteStudentById(UUID studentId);
    Set<FieldOfStudy> getStudentFields(UUID studentId);
}
