package com.youneskarir.springbootjpamanytomanycrud.repository;

import com.youneskarir.springbootjpamanytomanycrud.model.Tutorial;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;


@AllArgsConstructor
class TutorialRepositoryTest {

    TutorialRepository tutorialRepository;
    
    
    @Test
    public void testGetTutorial(){
        Tutorial tutorial = tutorialRepository.findById(1l).get();
        System.out.println(tutorial);
        
    }
    
    
    
    
    
    
}
