package com.bca.itworks.repository;

import java.util.List;

import com.bca.itworks.model.Book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {
    List<Book> findByCreatedBy(String createdBy);
}
