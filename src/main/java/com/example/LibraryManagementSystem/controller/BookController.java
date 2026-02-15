package com.example.LibraryManagementSystem.controller;

import com.example.LibraryManagementSystem.dto.BookRequest;
import com.example.LibraryManagementSystem.entity.Book;
import com.example.LibraryManagementSystem.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    public Book createBook(@RequestBody BookRequest request) {

        return bookService.createBook(request);
    }

    @GetMapping
    public List<Book> getAllBooks() {

        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {

        return bookService.getBookById(id);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id,
                           @RequestBody BookRequest request) {

        return bookService.updateBook(id, request);
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {

        bookService.deleteBook(id);

        return "Book deleted successfully";
    }
}