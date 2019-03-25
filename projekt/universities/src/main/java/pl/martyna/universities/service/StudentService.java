package pl.martyna.universities.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.martyna.universities.dao.IStudentDAO;
import pl.martyna.universities.dao.StudentDAO;
import pl.martyna.universities.model.Student;

import java.util.List;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private IStudentDAO studentDAO;

    @Override
    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }
}
