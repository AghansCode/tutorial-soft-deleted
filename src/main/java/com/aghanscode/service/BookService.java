package com.aghanscode.service;

import javax.persistence.EntityManager;

import com.aghanscode.entity.Books;
import com.aghanscode.repo.BookRepo;

import org.hibernate.Session;
import org.hibernate.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private BookRepo bookRepo;

    public Books createBooks(Books books){
        return bookRepo.save(books);
    }

    public void remove(Long id){
        bookRepo.deleteById(id);
    }

    public Iterable<Books> findAll(boolean isDeleted){
        // return bookRepo.findAll();
        
        Session session = entityManager.unwrap(Session.class);
        Filter filter = session.enableFilter("deletedBookFilter");
        filter.setParameter("isDeleted", isDeleted);
        Iterable<Books> books = bookRepo.findAll();
        session.disableFilter("deletedBookFilter");
        return books;
    } 

}
