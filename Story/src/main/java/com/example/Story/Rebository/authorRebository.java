package com.example.Story.Rebository;

import com.example.Story.Entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface authorRebository extends JpaRepository<Author, Long> {

    boolean existsByUsername(String username);
    Author findByUsername(String username);

}
