package com.bookstore.controllers;

import com.bookstore.domain.Book;
import com.bookstore.dtos.BookDto;
import com.bookstore.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping(value = "/{id}")
    public ResponseEntity<Book> findById(@PathVariable Integer id){
        Book obj = bookService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<BookDto>> findAll(@RequestParam(value = "category", defaultValue = "0")Integer id_cat){
        List<Book> list = bookService.findAll(id_cat);
        List<BookDto> listDto = list.stream().map(BookDto::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
        //localhost:8080/books?category=1
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Book> update(@PathVariable Integer id, @RequestBody Book obj){
        Book newObj = bookService.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Book> updatePatch(@PathVariable Integer id, @RequestBody Book obj){
        Book newObj = bookService.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }




}
