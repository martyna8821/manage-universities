package pl.martyna.universities.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.martyna.universities.dao.IGenericDao;
import pl.martyna.universities.model.Student;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService implements IStudentService {

    private IGenericDao<Student> studentDao;

    @Autowired
    public void setDao( IGenericDao< Student > daoToSet ){
        studentDao = daoToSet;
        studentDao.setClassT(Student.class);
    }

    @Override
    public Optional<Student> getStudentById(UUID studentId) {
        return Optional.ofNullable(studentDao.getById(studentId));
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDao.getAll();
    }

    @Override
    public void createStudent(Student student) {
        studentDao.create(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentDao.update(student);
    }

    @Override
    public void deleteStudent(Student student) {
        studentDao.delete(student);
    }

    @Override
    public void deleteStudentById(UUID studentId) {
        studentDao.deleteById(studentId);
    }
}
