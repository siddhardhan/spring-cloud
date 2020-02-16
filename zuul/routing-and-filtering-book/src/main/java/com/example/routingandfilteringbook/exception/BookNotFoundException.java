package com.example.routingandfilteringbook.exception;

public class BookNotFoundException extends RuntimeException {

  public BookNotFoundException() {
    super("No Book found");
  }
}
