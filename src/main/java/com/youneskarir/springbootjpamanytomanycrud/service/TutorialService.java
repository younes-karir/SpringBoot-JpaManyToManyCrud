package com.youneskarir.springbootjpamanytomanycrud.service;

import com.youneskarir.springbootjpamanytomanycrud.dto.TutorialRequest;
import com.youneskarir.springbootjpamanytomanycrud.dto.TutorialResponse;
import com.youneskarir.springbootjpamanytomanycrud.model.Tag;
import com.youneskarir.springbootjpamanytomanycrud.model.Tutorial;

import java.util.List;

public interface TutorialService {
    
    // basic crud operations
    
    public Tutorial createTutorial(TutorialRequest request);
    public Tutorial updateTutorial(Long id,Tutorial tutorial);
    public List<Tag> getAllTags(Long tutorialId);
    public Object deleteTutorial(Long id);
    public Tutorial getTutorial(Long id);
    public List<TutorialResponse> getAll();
    public Tag deleteTagFromTutorial(Long tutorialId,Long TagId);
    // Many to Many Operations
    
    
}
