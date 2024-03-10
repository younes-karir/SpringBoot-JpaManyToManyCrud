package com.youneskarir.springbootjpamanytomanycrud.repository;

import com.youneskarir.springbootjpamanytomanycrud.dto.TutorialResponse;
import com.youneskarir.springbootjpamanytomanycrud.model.Tag;
import com.youneskarir.springbootjpamanytomanycrud.model.Tutorial;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface TutorialRepository extends JpaRepository<Tutorial,Long> {


    
    @Query("SELECT t FROM Tag t JOIN t.tutorials tutorial WHERE tutorial.id = :id")
    List<Tag> findByTutorialId(@Param("id") Long id);

    
    @Query("SELECT t FROM Tag t JOIN t.tutorials tutorial " +
            "WHERE tutorial.id = :tutorial_id AND t.id = :tag_id")
    Tag findByTutorialIdAndTagId(
            @Param("tutorial_id") Long tutorial_id,
            @Param("tag_id") Long tag_id);


    @Query("SELECT new com.youneskarir.springbootjpamanytomanycrud.dto.TutorialResponse(t.id,t.title,t.description,t.published) FROM Tutorial t")
    List<TutorialResponse> findAllTutorialsDTO();

    
    
    @Transactional
    void deleteById(Long id);

    
    
    
}
