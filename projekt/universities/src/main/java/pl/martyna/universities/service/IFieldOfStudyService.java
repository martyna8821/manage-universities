package pl.martyna.universities.service;

import pl.martyna.universities.model.FieldOfStudy;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IFieldOfStudyService {

    Optional<FieldOfStudy> getFieldOfStudyById(UUID fieldOfStudyId);
    List<FieldOfStudy> getAllFieldsOfStudy();
    void createFieldOfStudy(FieldOfStudy fieldOfStudy);
    void updateFieldOfStudy(FieldOfStudy fieldOfStudy);
    void deleteFieldOfStudy(FieldOfStudy fieldOfStudy);
    void deleteFieldOfStudyById(UUID fieldOfStudyId);
}
