package com.example.LibraryManagementSystem.services;

import com.example.LibraryManagementSystem.entity.Author;
import com.example.LibraryManagementSystem.repository.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepo authorRepo;

    public List<Author> getAllAuthors() {
        return authorRepo.findAll();
    }

    public Author getAuthorById(Long id) {
        return authorRepo.findById(id).orElse(null);
    }

    public Author saveOrUpdateAuthor(Author author) {
        return authorRepo.save(author);
    }

    public void deleteAuthorById(Long id) {
        authorRepo.deleteById(id);
    }
}