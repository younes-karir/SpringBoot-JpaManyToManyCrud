package com.youneskarir.springbootjpamanytomanycrud.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TutorialRequest {
    
    @NotEmpty(message = "title is empty ")
    @Size(min = 3, message ="title is less than 3 character" )
    private String title;

    @NotEmpty(message = "description is empty ")
    @Size(min = 3, message ="description is less than 3 character" )
    private String description;
}
