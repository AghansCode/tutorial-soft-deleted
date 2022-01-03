package com.aghanscode.controller;

import com.aghanscode.entity.Books;
import com.aghanscode.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class BookController {
    
    @Autowired
    private BookService bookService;

    @PostMapping
    public Books createBooks(@RequestBody Books books){
        return bookService.createBooks(books);

    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable("id") Long id){
            bookService.remove(id);
    }

    @GetMapping
    public Iterable<Books> findAll(@RequestParam(value = "isDeleted", required = false, defaultValue = "false") boolean isDeleted){
        return bookService.findAll(isDeleted);
    }

}
