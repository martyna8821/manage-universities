package pl.martyna.universities.service;

import pl.martyna.universities.model.FieldOfStudy;
import pl.martyna.universities.model.Student;
import pl.martyna.universities.model.University;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface IUniversityService {

    Optional<University> getUniversityById(UUID universityId);
    List<University> getAllUniversities();
    void createUniversity(University university);
    void updateUniversity(University university);
    void deleteUniversity(University university);
    void deleteUniversityById(UUID universityId);
    Set<Student> getUniversityStudents(UUID universityId);
    List<FieldOfStudy> getUniversityFields(UUID universityId);
}
