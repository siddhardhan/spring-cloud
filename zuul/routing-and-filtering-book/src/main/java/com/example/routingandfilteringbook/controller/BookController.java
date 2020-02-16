package com.example.routingandfilteringbook.controller;

import com.example.routingandfilteringbook.model.Book;
import com.example.routingandfilteringbook.service.BookService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@Api(value = "Book Management System")
public class BookController {

  private static final Logger LOGGER = LoggerFactory.getLogger(BookController.class);
  @Autowired BookService bookService;

  /*@ApiOperation(
  value = "View a list of available books",
  response = Book.class,
  responseContainer = "List")*/
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Successfully retrieved list"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(
            code = 403,
            message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
      })
  /*@GetMapping("/books")
  public @ResponseBody ResponseEntity<List<Book>> getBooksList() {
    return ResponseEntity.ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(bookService.getBooksList());
  }*/

  @ApiOperation(value = "Get a book by Id and Name", response = Book.class)
  @GetMapping("/books")
  public @ResponseBody ResponseEntity<Book> getBookById(
      @ApiParam(value = "Book id from which book object will retrieve", required = true)
          @RequestParam(value = "id")
          String bookId,
      @RequestParam(value = "name") String bookName) {
    return ResponseEntity.ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(bookService.getBookbyIdAndName(bookId, bookName));
  }
}
