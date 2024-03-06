package com.youneskarir.springbootjpamanytomanycrud.service;

import com.youneskarir.springbootjpamanytomanycrud.dto.TagRequest;
import com.youneskarir.springbootjpamanytomanycrud.model.Tag;
import com.youneskarir.springbootjpamanytomanycrud.model.Tutorial;

import java.util.List;
import java.util.Optional;

public interface TagService {

    // basic crud operations 
    public Tutorial createTag(Long tutorialId,TagRequest request);
    public Tag updateTag(Long id,Tag request);
    public Tag deleteTag(Long id);
    public Tag getTag(Long id);
    public List<Tag> getAll();
    public List<Tutorial> getTagTutorials(Long id);
    
    
    public Object getTutorial(Long id);
    
}
