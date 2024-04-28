package com.bookapi.service;

import com.bookapi.entity.Book;
import com.bookapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookService {

    @Autowired
    private BookRepository bookRepository;

//    private static List<Book> list = new ArrayList<>();
//
//    static {
//        list.add(new Book(12,"Python","Cody"));
//        list.add(new Book(13,"DBMS","Steve"));
//        list.add(new Book(14,"react","Shivam"));
//    }

    // get All books
    public List<Book> getAllBooks() {
        return (List<Book>)bookRepository.findAll();
    }

    // get Single Book By id
    public Book getBookById(int id) {
        Book book = null;
        try {
            //book = list.stream().filter(e -> e.getId() == id).findFirst().get();
            book = bookRepository.findById(id);
        }catch (Exception e) {
            System.err.println("Failed to find book");
        }
        return book;
    }

    public Book addBook(Book book) {
        //list.add(book);
        return bookRepository.save(book);
    }

    public void removeBook(int id) {
//        list = list.stream().filter(e -> e.getId() != id).collect(Collectors.toList());
        bookRepository.deleteById(id);
    }

    public void updateBook(Book book , int id){
//        list = list.stream().peek(b -> {
//            if (b.getId() == id){
//                b.setTitle(book.getTitle());
//                b.setAuthor(book.getAuthor());
//            }
//        }).collect(Collectors.toList());

        book.setId(id);
        bookRepository.save(book);
    }


}
