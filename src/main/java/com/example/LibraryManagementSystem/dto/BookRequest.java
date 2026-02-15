package com.example.LibraryManagementSystem.dto;

import lombok.Data;

import java.util.*;

@Data
public class BookRequest {

    private String title;
    private String isbn;
    private Integer publicationYear;
    private Integer quantity;
    private Integer availableQuantity;

    private List<String> author;
    private List<String> category;

}
