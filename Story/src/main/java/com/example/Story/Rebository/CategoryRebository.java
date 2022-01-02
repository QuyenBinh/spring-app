package com.example.Story.Rebository;

import com.example.Story.Entity.Category;
import com.example.Story.Model.ECategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRebository extends JpaRepository<Category, Long> {

    Category findByName(String Category);

}
