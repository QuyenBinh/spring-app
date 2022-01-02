package com.example.Story.DTO;

import com.example.Story.Entity.Story;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;

@Data
public class ChapterDTO {

    @JsonProperty
    private long id;
    private String index;
    private String title;
    private String content;
    private Story story;

}
