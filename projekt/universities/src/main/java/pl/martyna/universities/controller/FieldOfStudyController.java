package pl.martyna.universities.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.martyna.universities.model.FieldOfStudy;
import pl.martyna.universities.service.IFieldOfStudyService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/")
public class FieldOfStudyController {

    @Autowired
    IFieldOfStudyService fieldOfStudyService;

    @GetMapping("field")
    public  ResponseEntity<List<FieldOfStudy>> getAllFieldsOfStudy(){

        List<FieldOfStudy> list = fieldOfStudyService.getAllFieldsOfStudy();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("field/{fieldId}")
    public ResponseEntity<?> getFieldOfStudyById(@PathVariable String fieldId){
        UUID idToSearch = UUID.fromString(fieldId);
        Optional<FieldOfStudy> foundField = fieldOfStudyService.getFieldOfStudyById(idToSearch);
        if(foundField.isPresent()){
            return new ResponseEntity<>(foundField.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Field of study not found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("field")
    public ResponseEntity<FieldOfStudy> createFieldOfStudy(@RequestBody FieldOfStudy field){
        fieldOfStudyService.createFieldOfStudy(field);
        return new ResponseEntity<>(field, HttpStatus.OK);
    }

    @PutMapping("field")
    public ResponseEntity<FieldOfStudy> updateFieldOfStudy(@RequestBody FieldOfStudy field){
        fieldOfStudyService.updateFieldOfStudy(field);
        return new ResponseEntity<>(field, HttpStatus.OK);
    }

    @DeleteMapping("field")
    public ResponseEntity<String> deleteFieldOfStudy(@RequestBody FieldOfStudy field){
        fieldOfStudyService.deleteFieldOfStudy(field);
        return new ResponseEntity<>("Field of study deleted", HttpStatus.OK);
    }

    @DeleteMapping("field/{fieldId}")
    public ResponseEntity<String> deleteFieldOfStudyById(@PathVariable String fieldId){
        UUID idToDelete = UUID.fromString(fieldId);
        fieldOfStudyService.deleteFieldOfStudyById(idToDelete);
        return new ResponseEntity<>("Field of study deleted", HttpStatus.OK);
    }
}
