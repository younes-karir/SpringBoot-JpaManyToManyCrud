package com.youneskarir.springbootjpamanytomanycrud.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
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
    private Long id;
    private String name;


    @ManyToMany(mappedBy = "tags")
    private Set<Tutorial> tutorials = new HashSet<>();
}
