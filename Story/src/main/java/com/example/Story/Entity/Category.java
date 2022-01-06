package com.example.Story.Entity;

import com.example.Story.Model.Categories;
import com.example.Story.Model.ECategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "category")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "title",nullable = false)
    private String name;
    @Column(name = "description", length = 1000000)
    private String description;
    @Column(name = "img_url")
    private String imgUrl;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Collection<StoryCategory> storyCategory;

}
