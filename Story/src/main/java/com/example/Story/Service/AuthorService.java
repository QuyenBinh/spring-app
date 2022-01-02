package com.example.Story.Service;

import com.example.Story.Entity.Author;
import com.example.Story.Rebository.authorRebository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private authorRebository authorrebository;

    public Author addAuthor(Author author) {

        return authorrebository.save(author);

    }

}
