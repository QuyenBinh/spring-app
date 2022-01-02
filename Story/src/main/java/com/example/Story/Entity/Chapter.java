package com.example.Story.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "chapter")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Chapter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "index",nullable = false)
    private String index;
    @Column(name= "title",nullable = false)
    private String title;
    @Column(name= "content",nullable = false,length = 100000)
    private String content;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "story_id")
    private Story story;

}
