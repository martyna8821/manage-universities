package pl.martyna.universities.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.martyna.universities.dao.IUniversityDAO;
import pl.martyna.universities.model.University;

import java.util.List;

@Service
public class UniversityService implements IUniversityService {

    @Autowired
    private IUniversityDAO universityDAO;

    @Override
    public List<University> getAllUniversities() {
        return universityDAO.getAllUniversities();
    }
}
