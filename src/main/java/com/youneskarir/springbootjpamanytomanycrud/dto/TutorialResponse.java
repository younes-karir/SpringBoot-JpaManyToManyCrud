package com.youneskarir.springbootjpamanytomanycrud.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class TutorialResponse {

    private Long id;
    private String title;
    private String description;
    private boolean published;
    
}
