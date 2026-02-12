package com.example.LibraryManagementSystem.services;

import com.example.LibraryManagementSystem.entity.Books;
import com.example.LibraryManagementSystem.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    public List<Books> getAllBooks() {
        return bookRepo.findAll();
    }

    public Books getBookById(Long id) {
        return bookRepo.findById(id).orElse(null);
    }

    public Books saveOrUpdateBook(Books book) {
        return bookRepo.save(book);
    }

    public void deleteBookById(Long id) {
        bookRepo.deleteById(id);
    }
}