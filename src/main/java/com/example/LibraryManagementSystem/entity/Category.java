package com.example.LibraryManagementSystem.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @ManyToMany(mappedBy = "categories")
    private Set<Book> books = new HashSet<>();

    public Category(String name) {
        this.name = name;
    }
}