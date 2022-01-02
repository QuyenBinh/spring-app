package com.example.Story.Rebository;

import java.util.List;
import java.util.Set;

import com.example.Story.Entity.Category;
import com.example.Story.Entity.Story;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StoryRebository extends JpaRepository<Story ,Long> {

    Story findById(long id);

    @Query(value = "SELECT cs.story_id FROM categories_stories cs where cs.category_id = :id" , nativeQuery = true)
    List<Story> findByIdAndCategory(@Param("id") long id);
    @Query(value = "SELECT story FORM StoryCategory WHERE Category = :category", nativeQuery = true)
    List<Story> findByCategory(@Param("category") Category category);
    @Query(value = "SELECT s.* FROM story s WHERE s.is_full = :bool", nativeQuery = true)
    List<Story> findIsFull(boolean bool);
    @Query(value ="SELECT * FROM Story WHERE name LIKE %:name% ", nativeQuery = true)
    List<Story> findByNameLike(String name);
    @Query(value ="SELECT * FROM Story WHERE name :=name ", nativeQuery = true)
    Story findByName(String name);

}
