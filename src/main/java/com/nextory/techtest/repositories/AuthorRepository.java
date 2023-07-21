package com.nextory.techtest.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nextory.techtest.models.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Integer>{
    
}
