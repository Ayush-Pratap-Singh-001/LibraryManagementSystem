package com.example.LibraryManagementSystem.services;

import com.example.LibraryManagementSystem.entity.Publisher;
import com.example.LibraryManagementSystem.repository.PublisherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepo publisherRepo;

    public List<Publisher> getAllPublisher() {
        return publisherRepo.findAll();
    }

    public Publisher getPublisherById(Long id) {
        return publisherRepo.findById(id).orElse(null);
    }

    public Publisher saveOrUpdate(Publisher publisher) {
        return publisherRepo.save(publisher);
    }

    public void deletePublisherById(Long id) {
        publisherRepo.deleteById(id);
    }
}