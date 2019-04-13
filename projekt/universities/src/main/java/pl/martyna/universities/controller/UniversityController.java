package pl.martyna.universities.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import pl.martyna.universities.model.University;
import pl.martyna.universities.service.IUniversityService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController

@RequestMapping("/")
public class UniversityController {

    @Autowired
    private IUniversityService universityService;

    @GetMapping("university")
    public ResponseEntity<List<University>> getAllUniversities() {
        List<University> list = universityService.getAllUniversities();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("university/{universityId}")
    public ResponseEntity<?> getUniversityById(@PathVariable String universityId) {
        UUID idToSearch = UUID.fromString(universityId);
        Optional<University> foundUniversity = universityService.getUniversityById(idToSearch);

        if (foundUniversity.isPresent()) {
            return new ResponseEntity<>(foundUniversity.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("University not found", HttpStatus.NOT_FOUND);
        }
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
    public ResponseEntity<String> deleteUniversityById(@RequestBody University university){
        universityService.deleteUniversity(university);
        return new ResponseEntity<>("University deleted", HttpStatus.OK);
    }


    @DeleteMapping("university/{universityId}")
    public ResponseEntity<String> deleteUniversity(@PathVariable String universityId){
        UUID idToDelete = UUID.fromString(universityId);
        universityService.deleteUniversityById(idToDelete);
        return new ResponseEntity<>("University deleted", HttpStatus.OK);
    }
}
