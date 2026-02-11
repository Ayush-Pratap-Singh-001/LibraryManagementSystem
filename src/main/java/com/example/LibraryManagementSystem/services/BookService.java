package com.example.LibraryManagementSystem.services;

import com.example.LibraryManagementSystem.entity.Author;
import com.example.LibraryManagementSystem.entity.Books;
import com.example.LibraryManagementSystem.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    public List<Author> getAllBooks() {
        return bookRepo.findAll();
    }

    public Author getBookById(int id) {
        return bookRepo.findById(id);
    }

    public Books saveOrUpdate(Books book) {
        return bookRepo.save(book);
    }

    public void deleteBookById(int id) {
        bookRepo.deleteById(id);
    }
}
