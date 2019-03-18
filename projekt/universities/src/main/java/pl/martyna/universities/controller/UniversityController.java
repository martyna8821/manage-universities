package pl.martyna.universities.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.martyna.universities.model.University;
import pl.martyna.universities.service.IUniversityService;

import java.util.List;

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
}
