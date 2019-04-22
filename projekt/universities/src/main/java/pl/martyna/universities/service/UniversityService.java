package pl.martyna.universities.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.martyna.universities.dao.IGenericDao;
import pl.martyna.universities.dao.IUniversityDao;
import pl.martyna.universities.model.University;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UniversityService implements IUniversityService {

    private IUniversityDao universityDao;

    @Autowired
    public void setDao( IUniversityDao daoToSet ){
        universityDao = daoToSet;
        universityDao.setClassT(University.class);
    }

    @Override
    public Optional<University> getUniversityById(UUID univesityId) {
        return Optional.ofNullable(universityDao.getById(univesityId));
    }

    @Override
    public List<University> getAllUniversities() {
        return universityDao.getAll();
    }

    @Override
    public void createUniversity(University university) {
        universityDao.create(university);
    }

    @Override
    public void updateUniversity(University university) {
        universityDao.update(university);
    }

    @Override
    public void deleteUniversity(University university){
        universityDao.delete(university);
    }

    @Override
    public void deleteUniversityById(UUID univesityId) {
        universityDao.deleteById(univesityId);
    }

    @Override
    public boolean checkIfExists(String name) {
        return false;
    }

    @Override
    public List<University> getUniversityStudents(UUID universityId) {
        return universityDao.getUniversityStudents(UUID universityId);
    }

}
