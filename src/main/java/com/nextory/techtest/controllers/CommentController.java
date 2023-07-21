package com.nextory.techtest.controllers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.nextory.techtest.models.Book;
import com.nextory.techtest.models.Comment;
import com.nextory.techtest.services.CommentService;

import jakarta.servlet.http.HttpServletResponse;

public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping("/api/addcomment")
    public void submitComment(@RequestParam("bookId") Long bookId,
            @RequestParam("pseudonyme") String pseudonyme,
            @RequestParam("content") String content,
            HttpServletResponse response) {
        Book book = new Book();
        book.setId(bookId);
        Comment comment = new Comment();
        comment.setPseudonyme(pseudonyme);
        comment.setContent(content);
        comment.setBook(new Book());
        comment.setCreatedAt(LocalDateTime.now());
        comment.setUpdatedAt(LocalDateTime.now());
        commentService.addComment(comment);
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
