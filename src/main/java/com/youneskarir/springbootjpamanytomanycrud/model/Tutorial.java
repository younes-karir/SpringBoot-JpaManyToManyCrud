package com.youneskarir.springbootjpamanytomanycrud.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Tutorial {
    
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE, 
            generator = "tutorial_sequence")
    @SequenceGenerator(name = "tutorial_sequence", 
            sequenceName = "tutorial_sequence")
    private Long id;
    private String title;
    private String description;
    private boolean published;
    
    // setting up the relation

    @ManyToMany(
            cascade ={CascadeType.MERGE,CascadeType.PERSIST})
    @JoinTable(
            name = "tutorial_tag",
            joinColumns = {
                    @JoinColumn(name = "tutorial_id") 
            },
            inverseJoinColumns = { 
                    @JoinColumn(name = "tag_id")
            }
    )
    private Set<Tag> tags ;
    
}
