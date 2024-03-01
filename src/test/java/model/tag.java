package model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class tag {
    
    
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
}
