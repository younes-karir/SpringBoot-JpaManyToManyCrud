package model;


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
    @Column(name = "tutorial_id")
    private Long id;
    private String title;
    private String description;
    private boolean published;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "tutorial_tag",
            joinColumns = { @JoinColumn(name = "tutorial_id") },
            inverseJoinColumns = { @JoinColumn(name = "tag_id") })
    private Set<Tag> tags = new HashSet<Tag>();
}
