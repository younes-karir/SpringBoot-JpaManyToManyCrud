package com.youneskarir.springbootjpamanytomanycrud.repository;

import com.youneskarir.springbootjpamanytomanycrud.model.Tag;
import com.youneskarir.springbootjpamanytomanycrud.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface TagRepository extends JpaRepository<Tag,Long> {


    @Query("SELECT t FROM Tag t JOIN t.tutorials tutorial WHERE tutorial.id = :id")
    List<Tag> findByTutorialId(@Param("id") Long id);
    
}
