package com.example.LibraryManagementSystem.repository;

import com.example.LibraryManagementSystem.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Books, Long> {
}