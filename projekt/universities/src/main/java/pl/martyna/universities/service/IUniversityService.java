package pl.martyna.universities.service;

import pl.martyna.universities.model.University;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IUniversityService {

    Optional<University> getUniversityById(UUID univesityId);
    List<University> getAllUniversities();
    void createUniversity(University university);
    void updateUniversity(University university);
    void deleteUniversity(University university);
    void deleteUniversityById(UUID univesityId);
    boolean checkIfExists(String name);
    List<University> getUniversityStudents(UUID universityId);
}
