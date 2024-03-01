package model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

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
    private Long id;
    private String title;
    private String description;
    private boolean published;
}
