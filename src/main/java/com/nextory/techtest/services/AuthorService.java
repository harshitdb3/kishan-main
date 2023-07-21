package com.nextory.techtest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextory.techtest.models.Author;
import com.nextory.techtest.repositories.AuthorRepository;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository; 

    public List<Author> getAllAuthors() {
        List<Author> authors = new ArrayList<Author>();
        authorRepository.findAll().forEach(author -> authors.add(author));
        
        return (authors);
    }

    public Author getAuthorById(Integer authorId) {
        return (authorRepository.findById(authorId).get());
    }
}
