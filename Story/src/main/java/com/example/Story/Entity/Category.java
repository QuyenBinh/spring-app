package com.example.Story.Entity;

//import com.example.Story.Model.ECategory;
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
    @Enumerated(EnumType.STRING)
    private ECategory name;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Collection<StoryCategory> storyCategory;

}
