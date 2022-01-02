package com.example.Story.Rebository;

import com.example.Story.Entity.Story;
import com.example.Story.Entity.StoryCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoryCategoryRebository extends JpaRepository<StoryCategory, Long > {

    @Query(value = "SELECT cs.* FROM categories_stories cs WHERE cs.category_id = :id" , nativeQuery = true)
    List<StoryCategory> findByCategory(@Param("id") long id);
    List<StoryCategory> findByStory(Story story);

}
