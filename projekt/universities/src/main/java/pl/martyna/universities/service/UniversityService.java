package pl.martyna.universities.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.martyna.universities.dao.IUniversityDAO;
import pl.martyna.universities.model.FieldOfStudy;
import pl.martyna.universities.model.University;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UniversityService implements IUniversityService {

    @Autowired
    private IUniversityDAO universityDAO;

    @Override
    public List<University> getAllUniversities() {
        return universityDAO.getAllUniversities();
    }

    @Override
    public Optional<University> getUniversityById(UUID univesityId) {
        return universityDAO.getUniversityById(univesityId);
    }

    @Override
    public void addUniversity(University university) {

    }

    @Override
    public void updateUniversity(University university) {

    }

    @Override
    public void deleteUniversity(UUID univesityId) {

    }

    @Override
    public boolean universityExists(String name) {
        return false;
    }


}
