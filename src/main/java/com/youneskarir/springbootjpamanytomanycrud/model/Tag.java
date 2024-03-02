package com.youneskarir.springbootjpamanytomanycrud.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tags")
public class Tag {
    
    
    @Id
    @SequenceGenerator(
            name = "tagIdSequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "tagIdSequence",
            strategy = GenerationType.SEQUENCE
    )
    @Column(name = "tag_id")
    private Long id;
    private String name;


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "tags")
    @JsonIgnore
    private Set<Tutorial> tutorials = new HashSet<>();
}
