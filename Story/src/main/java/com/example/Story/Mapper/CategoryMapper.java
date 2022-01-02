package com.example.Story.Mapper;

import com.example.Story.DTO.CategoryDTO;
import com.example.Story.Entity.Category;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public CategoryDTO EntityToDTO(Category category)    {
        CategoryDTO dto = new CategoryDTO();
        dto.setId(category.getId());
        dto.setDescription(category.getDescription());
        dto.setImage_url(category.getImgUrl());
        dto.setCategory(category.getName());
        return dto;
    }
}
