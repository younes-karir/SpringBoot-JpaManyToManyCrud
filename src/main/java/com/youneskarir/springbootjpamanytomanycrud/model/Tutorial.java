package com.youneskarir.springbootjpamanytomanycrud.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tutorials")
public class Tutorial {
    
    @Id
    @GeneratedValue(
            generator = "tutorialIdSequence",
            strategy = GenerationType.SEQUENCE
    )
    @SequenceGenerator(
            name = "tutorialIdSequence",
            sequenceName = "tutorialIdSequence",
            allocationSize = 1
    )

    private Long id;
    private String title;
    private String description;
    private boolean published;
    
    // setting up the relation

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "tutorials_tags",
            joinColumns = {
                    @JoinColumn(name = "tutorial_id") 
            },
            inverseJoinColumns = { 
                    @JoinColumn(name = "tag_id")
            }
    )
    private Set<Tag> tags = new HashSet<Tag>();
}
