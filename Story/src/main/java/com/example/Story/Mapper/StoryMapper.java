package com.example.Story.Mapper;

import com.example.Story.DTO.StoryDTO;
import com.example.Story.Entity.Story;
import com.example.Story.Entity.StoryCategory;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class StoryMapper {

    public StoryDTO covertEntityToDTO(Story story)    {

        StoryDTO dto = new StoryDTO();
        dto.setId(story.getId());
        dto.setImageUrl(story.getImageUrl());
        dto.setName(story.getName());
        dto.setIntroduction(story.getIntroduction());
        dto.setFull(story.isFull());
        dto.setNameAuthor(story.getAuthor().getUsername());
        return dto;

    }

    public Story covertDtoToEntity(StoryDTO dto)    {
        Story story = new Story();
        return story;
    }

}
