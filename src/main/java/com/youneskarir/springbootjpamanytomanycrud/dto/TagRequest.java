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
public class TagRequest {

    @NotEmpty(message = "name is empty ")
    @Size(min = 3, message ="name is less than 3 character" )
    private String name;
}
