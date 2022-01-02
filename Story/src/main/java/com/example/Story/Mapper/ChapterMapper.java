package com.example.Story.Mapper;

import com.example.Story.DTO.ChapterDTO;
import com.example.Story.Entity.Chapter;
import org.springframework.stereotype.Component;


@Component
public class ChapterMapper {

    public ChapterDTO entityToDTO(Chapter chapter) {

        ChapterDTO dto = new ChapterDTO();
        dto.setId(chapter.getId());
        dto.setIndex(chapter.getIndex());
        dto.setTitle(chapter.getContent());
        dto.setTitle(chapter.getTitle());
     //   dto.setStory(chapter.getStory());
        return dto;
    }
    public Chapter DtoToEntity(ChapterDTO dto) {

        Chapter chapter = new Chapter();
        chapter.setIndex(dto.getIndex());
        chapter.setTitle(dto.getContent());
        chapter.setTitle(dto.getTitle());
   //     chapter.setStory(dto.getStory());
        return chapter;

    }

}
