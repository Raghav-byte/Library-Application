package com.example.Library.controller;


import com.example.Library.models.Book;
import com.example.Library.services.BookServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/books")

public class BookController {

    @Autowired
    private BookServices bookServices;

    @ApiOperation("This api is to create book")
    @PostMapping("/createBook")
    public Book createBook(@RequestBody Book book)
    {
        return bookServices.createBook(book);
    }

    @ApiOperation("This api is to show all books")
    @GetMapping("/showBook")
    public List<Book> showAllBooks()
    {
        return bookServices.showAllBooks();
    }

    @ApiOperation("This api is to show one book")
    @GetMapping("/{bookId}")
    public Optional<Book> oneBook(@PathVariable UUID bookId)
    {
        return bookServices.oneBook(bookId);
    }

    @ApiOperation("This api is to delete book")
    @DeleteMapping("/{bookId}")
    public String deleteBook(@PathVariable UUID bookId)
    {
        return bookServices.deleteBook(bookId);
    }

    @ApiOperation("This api is to update book")
    @PutMapping("/updateBook")
    public Book updateBook(@RequestBody Book book)
    {
        return bookServices.updateBook(book);
    }

}
