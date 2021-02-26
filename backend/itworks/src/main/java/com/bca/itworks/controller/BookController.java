package com.bca.itworks.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.bca.itworks.model.Book;
import com.bca.itworks.repository.BookRepository;
import com.bca.itworks.service.LoginService;
import com.bca.itworks.util.JWTTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookRepository bookRepo;

    @Autowired
    LoginService loginService;

    @GetMapping("")
    public ResponseEntity<List<Book>> getBooksByCreator(HttpServletRequest req) {
        try {

            String userId = loginService
                    .extractUserIdFromValidJWT(JWTTokenizer.validateJWT(req.getHeader("Authorization")));
            if (null == userId)
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

            List<Book> books = new ArrayList<>();

            bookRepo.findByCreatedBy(userId).forEach(books::add);

            if (books.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(books, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<Book> createBook(@RequestBody Book book, HttpServletRequest req) {
        try {
            String userId = loginService
                    .extractUserIdFromValidJWT(JWTTokenizer.validateJWT(req.getHeader("Authorization")));
            if (null == userId)
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

            if (book.getTitle() == null)
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

            Book _book = bookRepo.save(new Book(book.getTitle(), userId));
            return new ResponseEntity<>(_book, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
