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
        UUID id = UUID.fromString(universityId);
        Optional<University> university = universityService.getUniversityById(id);

        if (university.isPresent()) {
            return new ResponseEntity<>(university.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("University not found", HttpStatus.NOT_FOUND);
        }
    }
        @PostMapping("univesity")
        public University addUniversity(@RequestBody University university){
            universityService.addUniversity(university);
            return university;
        }

        @PutMapping("university")
        public University updateUniversity(@RequestBody University university){
            universityService.updateUniversity(university);
            return university;
        }

        @DeleteMapping("university/{universityId}")
        public ResponseEntity<String> deleteUniversity(@PathVariable String universityId){
        UUID id = UUID.fromString(universityId);
        universityService.deleteUniversity(id);
        return ResponseEntity.ok("ok");
    }



}
