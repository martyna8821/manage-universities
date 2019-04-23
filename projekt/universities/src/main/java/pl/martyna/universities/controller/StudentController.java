package pl.martyna.universities.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @Autowired
    private IStudentService studentService;

    @GetMapping("student")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> list = studentService.getAllStudents();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("student/{studentId}")
    public ResponseEntity<?> getStudentById(@PathVariable String studentId){
        UUID idToSearch = UUID.fromString(studentId);
        Optional<Student>  foundStudent = studentService.getStudentById(idToSearch);
        if(foundStudent.isPresent()){
            return new ResponseEntity<>(foundStudent.get(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
        }
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
    public ResponseEntity<String> deleteStudentById(@PathVariable String studentd){
        UUID idToDelete = UUID.fromString(studentd);
        studentService.deleteStudentById(idToDelete);
        return new ResponseEntity<>("Student deleted", HttpStatus.OK);
    }

    @GetMapping("student/{studentId}/field")
    public ResponseEntity<Set<FieldOfStudy>> getStudentFields(
            @PathVariable String studentId){

        UUID idToSearch = UUID.fromString(studentId);
        Set<FieldOfStudy> fields = studentService.getStudentFields(idToSearch);
        return new ResponseEntity<>(fields, HttpStatus.OK);
    }

}

