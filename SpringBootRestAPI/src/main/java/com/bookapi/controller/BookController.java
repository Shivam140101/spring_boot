package com.bookapi.controller;


import com.bookapi.entity.Book;
import com.bookapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping("/books")
    public List<Book> getBooks(){
        return service.getAllBooks();
    }

    @GetMapping("/getBook/{id}")
    public Book getBook(@PathVariable("id") int id){
        return service.getBookById(id);
    }

    @PostMapping("/addBook")
    public Book addBook(@RequestBody Book book){
        return service.addBook(book);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook( @PathVariable("id") int id){
        service.removeBook(id);
        return "Book Deleted Successfully";
    }

    @PutMapping("update/{id}")
    public String updateBook(@RequestBody Book book, @PathVariable("id") int id){
        service.updateBook(book, id);
        return "Book Updated Successfully";
    }

}
