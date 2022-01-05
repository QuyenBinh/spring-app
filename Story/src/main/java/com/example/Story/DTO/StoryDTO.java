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
    @JsonProperty("image_url")
    private String imageUrl;
    private String introduction;
    @JsonProperty("author")
    private String nameAuthor;
    private boolean isFull;
    @JsonProperty("categories")
    private List<String> category;
    private List<ChapterDTO> chapter;

}
