package com.aghanscode.repo;

import com.aghanscode.entity.Books;

import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends CrudRepository<Books, Long> {
    
}
