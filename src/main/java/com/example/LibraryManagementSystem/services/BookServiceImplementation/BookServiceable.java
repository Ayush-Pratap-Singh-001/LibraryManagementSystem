package com.example.LibraryManagementSystem.services.BookServiceImplementation;

import com.example.LibraryManagementSystem.dto.BookRequest;
import com.example.LibraryManagementSystem.entity.Author;
import com.example.LibraryManagementSystem.entity.Book;
import com.example.LibraryManagementSystem.entity.Category;
import com.example.LibraryManagementSystem.exception.ResourceNotFoundException;
import com.example.LibraryManagementSystem.repository.AuthorRepository;
import com.example.LibraryManagementSystem.repository.BookRepository;
import com.example.LibraryManagementSystem.repository.CategoryRepository;
import com.example.LibraryManagementSystem.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class BookServiceable implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;

    public Book createBook(BookRequest request) {

        Set<Author> authors = new HashSet<>();

        for (String name : request.getAuthor()) {

            Author author = authorRepository.findByName(name)
                    .orElseGet(() -> authorRepository.save(new Author(name)));

            authors.add(author);
        }

        Set<Category> categories = new HashSet<>();

        for (String name : request.getCategory()) {

            Category category = categoryRepository.findByName(name)
                    .orElseGet(() -> categoryRepository.save(new Category(name)));

            categories.add(category);
        }

        Book book = new Book();

        book.setTitle(request.getTitle());
        book.setIsbn(request.getIsbn());
        book.setPublicationYear(request.getPublicationYear());
        book.setQuantity(request.getQuantity());
        book.setAvailableQuantity(request.getAvailableQuantity());

        book.setAuthors(authors);
        book.setCategories(categories);

        return bookRepository.save(book);
    }

    public List<Book> getAllBooks() {

        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {

        return bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));
    }

    @Override
    public Book updateBook(Long id, BookRequest request) {

        Book book = getBookById(id);

        book.setTitle(request.getTitle());
        book.setIsbn(request.getIsbn());
        book.setPublicationYear(request.getPublicationYear());
        book.setQuantity(request.getQuantity());
        book.setAvailableQuantity(request.getAvailableQuantity());

        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {

        Book book = getBookById(id);

        bookRepository.delete(book);
    }
}
