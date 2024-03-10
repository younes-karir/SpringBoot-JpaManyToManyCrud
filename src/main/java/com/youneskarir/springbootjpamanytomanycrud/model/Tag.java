package com.youneskarir.springbootjpamanytomanycrud.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Tag {
    
    
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "tag_sequence"
    )
    @SequenceGenerator(
            name = "tag_sequence",
            sequenceName = "tag_sequence"
    )
    private Long id;
    private String name;


    @ManyToMany(mappedBy = "tags")
    @JsonIgnore
    private Set<Tutorial> tutorials ;
}
