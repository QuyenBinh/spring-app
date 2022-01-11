package com.example.Story.DTO;

import com.example.Story.Model.Categories;
import com.example.Story.Model.ECategory;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CategoryDTO {

    private long id;
    private String Category;
    private String description;
    private String image_url;
    private long count;

}
