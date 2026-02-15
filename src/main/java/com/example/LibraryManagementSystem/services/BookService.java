package com.example.LibraryManagementSystem.services;

import com.example.LibraryManagementSystem.dto.BookRequest;
import com.example.LibraryManagementSystem.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {

    Book createBook(BookRequest request);

    List<Book> getAllBooks();

    Book getBookById(Long id);

    Book updateBook(Long id, BookRequest request);

    void deleteBook(Long id);
}