package com.example.Story.Rebository;

import com.example.Story.Entity.Chapter;
import com.example.Story.Entity.Story;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChapterRebository  extends JpaRepository<Chapter, Long> {

    Chapter findByIndexAndStory(String index, Story story);

}
