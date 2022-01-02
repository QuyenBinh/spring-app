package com.example.Story.Request;

import com.example.Story.Entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class storyRequest {

    private String nameStory;
    private String nameAuthor;
    private String imageUrl;
    private String introduction;
    private boolean isFull;
    private Set<String> category;

}
