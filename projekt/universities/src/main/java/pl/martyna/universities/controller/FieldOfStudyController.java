package pl.martyna.universities.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.martyna.universities.model.FieldOfStudy;
import pl.martyna.universities.service.IFieldOfStudyService;

import java.util.List;

@RestController
@RequestMapping("/")
public class FieldOfStudyController {

    @Autowired
    IFieldOfStudyService fieldOfStudyService;

    @RequestMapping("field")
    public  ResponseEntity<List<FieldOfStudy>> getAllFieldsOfStudy(){

        List<FieldOfStudy> list = fieldOfStudyService.getAllFieldsOfStudy();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
