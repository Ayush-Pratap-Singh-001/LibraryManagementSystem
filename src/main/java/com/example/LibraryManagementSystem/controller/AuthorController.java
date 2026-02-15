package com.example.LibraryManagementSystem.controller;

import com.example.LibraryManagementSystem.entity.Author;
import com.example.LibraryManagementSystem.exception.ResourceNotFoundException;
import com.example.LibraryManagementSystem.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorRepository authorRepository;

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id: " + id));
    }

    @PostMapping
    public Author createAuthor(@RequestBody Author author) {
        return authorRepository.save(author);
    }

    @PutMapping("/{id}")
    public Author updateAuthor(@PathVariable Long id, @RequestBody Author authorDetails) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id: " + id));
        author.setName(authorDetails.getName());
        return authorRepository.save(author);
    }

    @DeleteMapping("/{id}")
    public String deleteAuthor(@PathVariable Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id: " + id));
        authorRepository.delete(author);
        return "Author deleted successfully";
    }
}
