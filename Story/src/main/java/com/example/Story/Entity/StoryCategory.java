package com.example.Story.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categories_stories")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StoryCategory {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "story_id")
        private Story story;
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "category_id")
        private Category category;

}
