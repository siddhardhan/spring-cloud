package com.example.routingandfilteringbook.controller;

import com.example.routingandfilteringbook.model.Book;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Api(value = "Book Management System")
public class BookController {

    private static final Logger LOGGER= LoggerFactory.getLogger(BookController.class);

    @ApiOperation(value = "View a list of available books", response = Book.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/books")
    public @ResponseBody ResponseEntity<List<Book>> getBooksList() {
        List<Book> list = new ArrayList<>();
        list.add(new Book("1", "Spring Boot"));
        list.add(new Book("2", "Spring Cloud"));
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(list);
    }

    @ApiOperation(value = "Get a book by Id", response = Book.class)
    @GetMapping("/books/{id}")
    public @ResponseBody ResponseEntity<Book> getBookById(
            @ApiParam(value = "Book id from which book object will retrieve", required = true) @PathVariable(value = "id") String bookId) {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(new Book(bookId, "Spring Boot"));
    }
}
