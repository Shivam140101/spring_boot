package com.bookapi.service;

import com.bookapi.entity.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookService {

    private static List<Book> list = new ArrayList<>();

    static {
        list.add(new Book(12,"Python","Cody"));
        list.add(new Book(13,"DBMS","Steve"));
        list.add(new Book(14,"react","Shivam"));
    }

    // get All books
    public List<Book> getAllBooks() {
        return list;
    }

    // get Single Book By id
    public Book getBookById(int id) {
        Book book;
        book = list.stream().filter(e -> e.getId() == id).findFirst().get();
        return book;
    }

    public Book addBook(Book book) {
        list.add(book);
        return book;
    }

    public void removeBook(int id) {
        list = list.stream().filter(e -> e.getId() != id).collect(Collectors.toList());
    }

    public void updateBook(Book book , int id){
        list = list.stream().peek(b -> {
            if (b.getId() == id){
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
            }
        }).collect(Collectors.toList());
    }


}
