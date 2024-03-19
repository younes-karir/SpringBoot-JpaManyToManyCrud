package com.youneskarir.springbootjpamanytomanycrud.controller;


import com.youneskarir.springbootjpamanytomanycrud.dto.TagRequest;
import com.youneskarir.springbootjpamanytomanycrud.model.Tutorial;
import com.youneskarir.springbootjpamanytomanycrud.response.ResponseHandler;
import com.youneskarir.springbootjpamanytomanycrud.service.TagService;
import com.youneskarir.springbootjpamanytomanycrud.service.TutorialService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class TagController {
    
    
    private TagService  tagService;
    private TutorialService tutorialService;
    
    @PostMapping("/tutorials/{id}/tags")
    public ResponseEntity<Object> createTag(@PathVariable Long id, @RequestBody  @Valid TagRequest request){
        
        return ResponseHandler.build(
                "tag created",
                HttpStatus.CREATED,
                tagService.createTag(id,request)
        );
    }
    
    @GetMapping("tags/{id}")
    public ResponseEntity<Object> getTag(@PathVariable Long id){
        return ResponseHandler.build("tag details",HttpStatus.OK,tagService.getTag(id));
    }
}
