package pl.martyna.universities.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.martyna.universities.dao.IGenericDao;
import pl.martyna.universities.dao.IUniversityDAO;
import pl.martyna.universities.model.FieldOfStudy;
import pl.martyna.universities.model.University;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UniversityService implements IUniversityService {

    private IGenericDao<University> universityDao;

    @Autowired
    public void setDao( IGenericDao< University > daoToSet ){
        universityDao = daoToSet;
        universityDao.setClassT(University.class);
    }


    @Override
    public List<University> getAllUniversities() {
        return universityDao.findAll();
    }

    @Override
    public Optional<University> getUniversityById(UUID univesityId) {
        return Optional.ofNullable(universityDao.findById(univesityId));
    }

    @Override
    public void addUniversity(University university) {
        universityDao.create(university);
    }

    @Override
    public void updateUniversity(University university) {
        universityDao.update(university);
    }

    @Override
    public void deleteUniversityById(UUID univesityId) {
        universityDao.deleteById(univesityId);
    }

    @Override
    public boolean universityExists(String name) {
        return false;
    }

    @Override
    public String name() {
        return universityDao.getClassName();
    }


}
