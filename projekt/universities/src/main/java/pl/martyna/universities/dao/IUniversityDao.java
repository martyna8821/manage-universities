package pl.martyna.universities.dao;

import pl.martyna.universities.model.University;

import java.util.List;
import java.util.UUID;

public interface IUniversityDao  extends IGenericDao<University>{

    List<University>  getUniversityStudents(UUID universityId);
}
