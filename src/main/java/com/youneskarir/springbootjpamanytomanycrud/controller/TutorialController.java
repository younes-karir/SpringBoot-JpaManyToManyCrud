package com.youneskarir.springbootjpamanytomanycrud.controller;


import com.youneskarir.springbootjpamanytomanycrud.dto.TutorialRequest;
import com.youneskarir.springbootjpamanytomanycrud.model.Tag;
import com.youneskarir.springbootjpamanytomanycrud.model.Tutorial;
import com.youneskarir.springbootjpamanytomanycrud.repository.TutorialRepository;
import com.youneskarir.springbootjpamanytomanycrud.response.ResponseHandler;
import com.youneskarir.springbootjpamanytomanycrud.service.TutorialService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/tutorials")
public class TutorialController {
    
    
    private TutorialService tutorialService;
    
    
    @PostMapping
    public ResponseEntity<Object> createTutorial(@RequestBody  @Valid TutorialRequest request){
       return ResponseHandler.build(
               "tutorial created",
               HttpStatus.CREATED,
               tutorialService.createTutorial(request)
       );
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> getTutorial(@PathVariable Long id){
        return ResponseHandler.build(
                "Tutorial details",
                HttpStatus.OK,
                tutorialService.getTutorial(id)
        );
    }
    
    
    @GetMapping
    public ResponseEntity<Object> getAll(){
        return ResponseHandler.build(
                "list of tutorials",
                HttpStatus.OK,
                tutorialService.getAll()
        );
    }
        
    @GetMapping("{id}/tags")
    public ResponseEntity<Object> getAllTutorialTags(@PathVariable Long id){
        return ResponseHandler.build(
                "list of tutorial tags",
                HttpStatus.OK,
                tutorialService.getAllTags(id)
        );
    }
    
    
    @PutMapping("{id}")
    public ResponseEntity<Object> updateTutorial(@PathVariable Long id,@RequestBody Tutorial tutorial){
        return ResponseHandler.build(
                "updated tutorial",
                HttpStatus.OK,
                tutorialService.updateTutorial(id,tutorial)
        );
    }
    
    
    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteTutorial(@PathVariable Long id){
        return ResponseHandler.build(
                "tutorial deleted",
                HttpStatus.OK,
                tutorialService.deleteTutorial(id)
        );
    }
    
    
    @DeleteMapping("{tutorialId}/tags/{tagId}")
    public ResponseEntity<Object> deleteTagFromTutorial(
            @PathVariable(name = "tutorialId") Long tutorialId,
            @PathVariable(name = "tagId") Long tagId
            ){

        return ResponseHandler.build(
                "tag was removed from tutorial",
                HttpStatus.OK,
                tutorialService.deleteTagFromTutorial(tutorialId,tagId)
        );
    }
    
    
    

    
}
