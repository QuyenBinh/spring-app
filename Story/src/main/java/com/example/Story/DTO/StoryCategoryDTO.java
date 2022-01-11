package com.example.Story.DTO;

import com.example.Story.Entity.Category;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StoryCategoryDTO {

    @JsonIgnore
    private Category category;
    private long count;

}
