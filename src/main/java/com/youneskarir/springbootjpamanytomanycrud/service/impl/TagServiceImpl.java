package com.youneskarir.springbootjpamanytomanycrud.service.impl;

import com.youneskarir.springbootjpamanytomanycrud.advice.exception.ElementAlreadyExistsException;
import com.youneskarir.springbootjpamanytomanycrud.advice.exception.ElementNotFoundException;
import com.youneskarir.springbootjpamanytomanycrud.dto.TagRequest;
import com.youneskarir.springbootjpamanytomanycrud.model.Tag;
import com.youneskarir.springbootjpamanytomanycrud.model.Tutorial;
import com.youneskarir.springbootjpamanytomanycrud.repository.TagRepository;
import com.youneskarir.springbootjpamanytomanycrud.repository.TutorialRepository;
import com.youneskarir.springbootjpamanytomanycrud.service.TagService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TagServiceImpl implements TagService {
    
    private TagRepository tagRepository;
    private TutorialRepository tutorialRepository;
    
    @Override
    public Tutorial createTag(Long tutorialId, TagRequest request) {
        if(tutorialRepository.findById(tutorialId).isEmpty())
            throw new ElementNotFoundException("tutorial not found");
        else {
            Tutorial tutorial = tutorialRepository.findById(tutorialId).get();
            if(request.getId() == null || request.getId() == 0L)
            {
                Tag tag = Tag.builder()
                        .name(request.getName())
                        .build();
                tutorial.getTags().add(tag);
                //return tagRepository.save(tag);
                return  tutorial;
            } 
            else if (tagRepository.findById(request.getId()).isEmpty()) 
                throw new ElementNotFoundException("tag not found");
            else
            {
                Tag tag = tagRepository.findById(request.getId()).get();
                if(!tagRepository.findByTutorialId(tutorialId).isEmpty()) throw new ElementAlreadyExistsException("tutorial already have the tag");
                else {
                    tutorial.getTags().add(tag);
                    
                    return tutorialRepository.save(tutorial);
                }
            }
        }
    }

    @Override
    public Tag updateTag(Long id, Tag request) {
        if(tagRepository.findById(id).isEmpty()) throw new ElementNotFoundException("tag not found");
    else {
        Tag tag = tagRepository.findById(id).get();
        tag.setName(request.getName());
        return tagRepository.save(tag);
        }
    }

    @Override
    public Tag deleteTag(Long id) {
        if(tagRepository.findById(id).isEmpty()) throw new ElementNotFoundException("tag not found");
        else {
            Tag tag = tagRepository.findById(id).get();
            tagRepository.delete(tag);
            return tag;
        }
    }

    @Override
    public Tag getTag(Long id) {
        if(tagRepository.findById(id).isEmpty()) throw new ElementNotFoundException("tag not found");
        else return tagRepository.findById(id).get();
    }

    @Override
    public List<Tag> getAll() {
        return tagRepository.findAll();
    }

    @Override
    public List<Tutorial> getTagTutorials(Long id) {
        return null;
        //return tagRepository.findById(id).get().getTutorials().stream().toList();
    }

    @Override
    public Object getTutorial(Long id) {
        return tutorialRepository.findById(id).get().getTags();
    }


}
