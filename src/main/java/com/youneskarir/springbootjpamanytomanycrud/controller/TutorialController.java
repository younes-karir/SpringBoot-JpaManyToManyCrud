package com.youneskarir.springbootjpamanytomanycrud.controller;


import com.youneskarir.springbootjpamanytomanycrud.dto.TutorialRequest;
import com.youneskarir.springbootjpamanytomanycrud.response.ResponseHandler;
import com.youneskarir.springbootjpamanytomanycrud.service.TutorialService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    
    @GetMapping("{id}")
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
    
    
    
    
}
