package pl.martyna.universities.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.martyna.universities.model.Student;
import pl.martyna.universities.service.IStudentService;

import javax.validation.constraints.Max;
import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @GetMapping("student")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> list = studentService.getAllStudents();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
