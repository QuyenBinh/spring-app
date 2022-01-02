package com.example.Story.DTO;

import com.example.Story.Entity.Category;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class StoryDTO {

    private long id;
    private String name;
    private String imageUrl;
    private String introduction;
    @JsonProperty
    private String nameAuthor;
    private boolean isFull;
    private List<Category> category;

}
