package pl.martyna.universities.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.martyna.universities.exception.NotFoundException;
import pl.martyna.universities.model.FieldOfStudy;
import pl.martyna.universities.model.Student;
import pl.martyna.universities.model.University;
import pl.martyna.universities.service.IUniversityService;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@RestController

@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200")
public class UniversityController {

    private final IUniversityService universityService;

    @Autowired
    public UniversityController(IUniversityService universityService) {
        this.universityService = universityService;
    }

    @GetMapping("university")
    public ResponseEntity<List<University>> getAllUniversities() {
        List<University> list = universityService.getAllUniversities();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("university/{universityId}")
    public ResponseEntity<?> getUniversityById(@PathVariable String universityId) {
        UUID idToSearch;
        try {
            idToSearch = UUID.fromString(universityId);
        }catch (IllegalArgumentException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Incorrect id");
        }

        Optional<University> foundUniversity = universityService.getUniversityById(idToSearch);
        return foundUniversity.<ResponseEntity<?>>map(university -> new ResponseEntity<>(university, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>("University not found", HttpStatus.NOT_FOUND));
    }
    @PostMapping("university")
    public University createUniversity(@RequestBody University university){
        universityService.createUniversity(university);
        return university;
    }

    @PutMapping("university")
    public University updateUniversity(@RequestBody University university){
        universityService.updateUniversity(university);
        return university;
    }

    @DeleteMapping("university")
    public HttpStatus deleteUniversityById(@RequestBody University university){
        universityService.deleteUniversity(university);
        return  HttpStatus.OK;
    }


    @DeleteMapping("university/{universityId}")
    public HttpStatus deleteUniversity(@PathVariable String universityId){
        UUID idToDelete = UUID.fromString(universityId);
        universityService.deleteUniversityById(idToDelete);
        return HttpStatus.OK;
    }

    @GetMapping("university/{universityId}/student")
    public ResponseEntity<Set<Student>> getUniversityStudents(@PathVariable String universityId)
            throws NotFoundException{

        UUID idToSearch;
        try {
            idToSearch =UUID.fromString(universityId);
        }catch (IllegalArgumentException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Incorrect id");
        }
        Set<Student> students =  universityService.getUniversityStudents(idToSearch);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("university/{universityId}/field")
    public ResponseEntity<List<FieldOfStudy>> getUniversityFields(
            @PathVariable String universityId) throws NotFoundException {
        UUID universityIdToSearch = UUID.fromString(universityId);
        List<FieldOfStudy> fields =  universityService.getUniversityFields(universityIdToSearch);
        return new ResponseEntity<>(fields, HttpStatus.OK);
    }

}
