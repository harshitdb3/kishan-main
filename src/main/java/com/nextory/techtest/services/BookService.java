package com.nextory.techtest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.nextory.techtest.models.Book;
import com.nextory.techtest.repositories.BookRepository;

@Service
public class BookService {
    
    @Autowired
    BookRepository bookRepository;

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<Book>();
        bookRepository.findAll().forEach(book -> books.add(book));

        return (books);
    }

    public Page<Book> getPaginatedBooks(int page, int pageSize) {
        int startIndex = (page - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, getAllBooks().size());

        List<Book> booksOnPage = getAllBooks().subList(startIndex, endIndex);

        return new PageImpl<>(booksOnPage, PageRequest.of(page - 1, pageSize), getAllBooks().size());
    }

    public Book getBookById(Integer bookId) {
        return (bookRepository.findById(bookId).get());
    }
}
