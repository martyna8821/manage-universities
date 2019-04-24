package pl.martyna.universities.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.martyna.universities.exception.NotFoundException;
import pl.martyna.universities.model.FieldOfStudy;
import pl.martyna.universities.model.Student;
import pl.martyna.universities.service.IStudentService;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/")
public class StudentController {

    private final IStudentService studentService;

    @Autowired
    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("student")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> list = studentService.getAllStudents();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("student/{studentId}")
    public ResponseEntity<?> getStudentById(@PathVariable String studentId){
        UUID idToSearch;
        try {
        idToSearch =UUID.fromString(studentId);
        }catch (IllegalArgumentException ex){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Incorrect id");
        }
        Optional<Student>  foundStudent = studentService.getStudentById(idToSearch);
        return foundStudent.<ResponseEntity<?>>map(student -> new ResponseEntity<>(student, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND));
    }

    @PostMapping("student")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        studentService.createStudent(student);
        return  new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PutMapping("student")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @DeleteMapping("student")
    public ResponseEntity<String> deleteStudent(@RequestBody Student student){
        studentService.deleteStudent(student);
        return new ResponseEntity<>("Student deleted", HttpStatus.OK);
    }

    @DeleteMapping("student/{studentId}")
    public ResponseEntity<String> deleteStudentById(@PathVariable String studentId){
        UUID idToDelete = UUID.fromString(studentId);
        studentService.deleteStudentById(idToDelete);
        return new ResponseEntity<>("Student deleted", HttpStatus.OK);
    }

    @GetMapping("student/{studentId}/field")
    public ResponseEntity<Set<FieldOfStudy>> getStudentFields (
            @PathVariable String studentId) throws NotFoundException {

        UUID idToSearch = UUID.fromString(studentId);
        Set<FieldOfStudy> fields = studentService.getStudentFields(idToSearch);
        return new ResponseEntity<>(fields, HttpStatus.OK);
    }

}

