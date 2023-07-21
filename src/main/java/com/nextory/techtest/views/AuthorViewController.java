package com.nextory.techtest.views;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nextory.techtest.models.Author;
import com.nextory.techtest.services.AuthorService;

@Controller
public class AuthorViewController {
    
    @Autowired
    AuthorService authorService;

    @GetMapping("/author")
    public String getAuthorPage(Model model) {
        List<Author> authors = authorService.getAllAuthors();
        model.addAttribute("authors", authors);

        return ("authors/index");
    }

    @GetMapping("/author/{id}")
    public String getAuthorPageDetail(@PathVariable("id") Integer _id, Model model) {
        Author author = authorService.getAuthorById(_id);
        model.addAttribute("author", author);

        return ("authors/detail");
    }
}
