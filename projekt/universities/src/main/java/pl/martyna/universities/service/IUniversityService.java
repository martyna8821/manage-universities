package pl.martyna.universities.service;

import pl.martyna.universities.model.FieldOfStudy;
import pl.martyna.universities.model.University;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IUniversityService {

    List<University> getAllUniversities();
    Optional<University> getUniversityById(UUID univesityId);
    void addUniversity(University university);
    void updateUniversity(University university);
    void deleteUniversity(UUID univesityId);
    boolean universityExists(String name);
}
