package com.youneskarir.springbootjpamanytomanycrud.service.impl;


import com.youneskarir.springbootjpamanytomanycrud.advice.exception.ElementNotFoundException;
import com.youneskarir.springbootjpamanytomanycrud.dto.TutorialRequest;
import com.youneskarir.springbootjpamanytomanycrud.dto.TutorialResponse;
import com.youneskarir.springbootjpamanytomanycrud.model.Tag;
import com.youneskarir.springbootjpamanytomanycrud.model.Tutorial;
import com.youneskarir.springbootjpamanytomanycrud.repository.TutorialRepository;
import com.youneskarir.springbootjpamanytomanycrud.service.TutorialService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class TutorialServiceImpl implements TutorialService {
    
    
    private TutorialRepository tutorialRepository;
    
    
    
    
    @Override
    public Tutorial createTutorial(TutorialRequest request) {
        Tutorial tutorial = Tutorial.builder()
                .description(request.getDescription())
                .title(request.getTitle())
                .published(true)
                .build();
        return tutorialRepository.save(tutorial);
    }

    @Override
    public Tutorial updateTutorial(Long id, Tutorial request) {
        if(tutorialRepository.findById(id).isEmpty()) throw  new ElementNotFoundException("tutorial not found");
        else{
            Tutorial tutorial = tutorialRepository.findById(id).get();
            tutorial.setDescription(request.getDescription());
            tutorial.setTitle(request.getTitle());
            return tutorialRepository.save(tutorial);
        }
    }

    @Override
    public List<Tag> getAllTags(Long tutorialId) {
        return tutorialRepository.findByTutorialId(tutorialId);
    }

    @Override
    public Tutorial deleteTutorial(Long id) {
        if(tutorialRepository.findById(id).isEmpty()) throw  new ElementNotFoundException("tutorial not found");
        else {
            Tutorial  tutorial = tutorialRepository.findById(id).get();
            tutorialRepository.delete(tutorial);
            return tutorial;
        }
        
    }

    @Override
    public Tutorial getTutorial(Long id) {
        if(tutorialRepository.findById(id).isEmpty()) throw  new ElementNotFoundException("tutorial not found");
        else {
            System.out.println(tutorialRepository.findByIdWithTags(id));
            return tutorialRepository.findByIdWithTags(id).get();
        }
    }

    @Override
    public List<TutorialResponse> getAll() {
        return tutorialRepository.findAllTutorialsDTO();
    }

    @Override
    public Tag deleteTagFromTutorial(Long tutorialId, Long TagId) {
        if(tutorialRepository.findById(tutorialId).isEmpty()) throw  new ElementNotFoundException("tutorial not found");
        else if(tutorialRepository.findByTutorialIdAndTagId(tutorialId,TagId) == null) throw  new ElementNotFoundException("tag not found");
        else {
            Tutorial tutorial = tutorialRepository.findById(tutorialId).get();
            Tag tag = tutorialRepository.findByTutorialIdAndTagId(tutorialId,TagId);
            tutorial.getTags().remove(tag);
            return tag;
        }
    }
}
