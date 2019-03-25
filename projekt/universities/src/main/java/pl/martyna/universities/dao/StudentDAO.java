package pl.martyna.universities.dao;

import org.springframework.stereotype.Repository;
import pl.martyna.universities.model.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class StudentDAO implements IStudentDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Student> getAllStudents() {
        return (List<Student>) entityManager.createQuery("from Student")
                .getResultList();
    }
}
