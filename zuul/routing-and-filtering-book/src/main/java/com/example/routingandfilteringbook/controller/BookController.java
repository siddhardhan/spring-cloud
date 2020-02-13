package com.example.routingandfilteringbook.controller;

import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@Api(value = "Book Management System")
public class BookController {

    private static final Logger LOGGER= LoggerFactory.getLogger(BookController.class);

    @ApiOperation(value = "View a list of available books", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/books")
    public String available() {
        return "Spring in Action";
    }

    @ApiOperation(value = "Get an book by Id")
    @GetMapping("/books/{id}")
    public String getBookById(
            @ApiParam(value = "Book id from which book object will retrieve", required = true) @PathVariable(value = "id") String bookId) {
        String response = "Spring in Action - Book ID#" + bookId;
        return response;
    }
}
