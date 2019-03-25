package pl.martyna.universities.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.martyna.universities.dao.IFieldOfStudyDAO;
import pl.martyna.universities.model.FieldOfStudy;

import java.util.List;

@Service
public class FieldOfStudyService implements IFieldOfStudyService {

    @Autowired
    IFieldOfStudyDAO fieldOfStudyDAO;

    @Override
    public List<FieldOfStudy> getAllFieldsOfStudy() {
        return fieldOfStudyDAO.getAllFieldsOfStudy();
    }
}
