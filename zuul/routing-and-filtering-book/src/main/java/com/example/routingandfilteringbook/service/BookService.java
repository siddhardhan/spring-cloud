package com.example.routingandfilteringbook.service;

import com.example.routingandfilteringbook.model.Book;

import java.util.List;

public interface BookService {
  List<Book> getBooksList();

  Book getBookbyIdAndName(String id, String name);
}
