package com.example.LibraryManagementSystem.controller;

import com.example.LibraryManagementSystem.entity.Publisher;
import com.example.LibraryManagementSystem.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/publishers")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @GetMapping
    public ResponseEntity<List<Publisher>> getAllPublishers() {
        return ResponseEntity.ok(publisherService.getAllPublisher());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publisher> getPublisher(@PathVariable Long id) {
        Publisher publisher = publisherService.getPublisherById(id);
        if (publisher == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(publisher);
    }

    @PostMapping
    public ResponseEntity<Publisher> savePublisher(@RequestBody Publisher publisher) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(publisherService.saveOrUpdate(publisher));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Publisher> updatePublisher(@PathVariable Long id, @RequestBody Publisher publisher) {
        Publisher existing = publisherService.getPublisherById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        publisher.setId(id);
        return ResponseEntity.ok(publisherService.saveOrUpdate(publisher));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePublisher(@PathVariable Long id) {
        publisherService.deletePublisherById(id);
        return ResponseEntity.noContent().build();
    }
}