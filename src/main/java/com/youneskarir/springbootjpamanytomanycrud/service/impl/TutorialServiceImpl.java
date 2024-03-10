package com.youneskarir.springbootjpamanytomanycrud.service.impl;


import com.youneskarir.springbootjpamanytomanycrud.advice.exception.ElementNotFoundException;
import com.youneskarir.springbootjpamanytomanycrud.dto.TutorialRequest;
import com.youneskarir.springbootjpamanytomanycrud.dto.TutorialResponse;
import com.youneskarir.springbootjpamanytomanycrud.model.Tag;
import com.youneskarir.springbootjpamanytomanycrud.model.Tutorial;
import com.youneskarir.springbootjpamanytomanycrud.repository.TutorialRepository;
import com.youneskarir.springbootjpamanytomanycrud.service.TutorialService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
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
            if(request.getTitle()!=null) tutorial.setTitle(request.getTitle());
            if(request.getDescription()!=null) tutorial.setDescription(request.getDescription());
            return tutorialRepository.save(tutorial);
        }
    }

    @Override
    public List<Tag> getAllTags(Long tutorialId) {
        return tutorialRepository.findById(tutorialId).get().getTags().stream().toList();
    }

    @Override
    public Object deleteTutorial(Long id) {
        if(tutorialRepository.findById(id).isEmpty()) throw  new ElementNotFoundException("tutorial not found");
        else {
            tutorialRepository.deleteById(id);
        }

        return null;
    }
    
   @Override
    public Tutorial getTutorial(Long id) {
        if(tutorialRepository.findById(id).isEmpty()) throw  new ElementNotFoundException("tutorial not found");
        else {
            System.out.println(tutorialRepository.findById(id));
            return tutorialRepository.findById(id).get();
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
            tutorialRepository.save(tutorial);
            return tag;
        }
    }
}
