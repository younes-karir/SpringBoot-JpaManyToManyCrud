package com.youneskarir.springbootjpamanytomanycrud.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class TutorialResponse {

    private Long id;
    private String title;
    private String description;
    private boolean published;
    
}
