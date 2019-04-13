package pl.martyna.universities.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.martyna.universities.dao.IGenericDao;
import pl.martyna.universities.model.FieldOfStudy;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FieldOfStudyService implements IFieldOfStudyService {

    private IGenericDao<FieldOfStudy> fieldOfStudyDao;

    @Autowired
    public void setDao( IGenericDao< FieldOfStudy > daoToSet ){
        fieldOfStudyDao = daoToSet;
        fieldOfStudyDao.setClassT(FieldOfStudy.class);
    }

    @Override
    public Optional<FieldOfStudy> getFieldOfStudyById(UUID fieldOfStudyId) {
        return Optional.ofNullable(fieldOfStudyDao.getById(fieldOfStudyId));
    }

    @Override
    public List<FieldOfStudy> getAllFieldsOfStudy() {
        return fieldOfStudyDao.getAll();
    }

    @Override
    public void createFieldOfStudy(FieldOfStudy fieldOfStudy) {
        fieldOfStudyDao.create(fieldOfStudy);
    }

    @Override
    public void updateFieldOfStudy(FieldOfStudy fieldOfStudy) {
        fieldOfStudyDao.update(fieldOfStudy);
    }

    @Override
    public void deleteFieldOfStudy(FieldOfStudy fieldOfStudy) {
        fieldOfStudyDao.delete(fieldOfStudy);
    }

    @Override
    public void deleteFieldOfStudyById(UUID fieldOfStudyId) {
        fieldOfStudyDao.deleteById(fieldOfStudyId);
    }
}
