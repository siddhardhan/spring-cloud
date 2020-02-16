package com.example.routingandfilteringbook.service;

import com.example.routingandfilteringbook.exception.BookNotFoundException;
import com.example.routingandfilteringbook.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

  @Override
  public List<Book> getBooksList() {
    List<Book> bookList = new ArrayList<>();
    bookList.add(new Book("1", "Spring Boot"));
    bookList.add(new Book("2", "Spring Cloud"));
    return bookList;
  }

  @Override
  public Book getBookbyIdAndName(String id, String name) {
    throw new BookNotFoundException();
  }
}
