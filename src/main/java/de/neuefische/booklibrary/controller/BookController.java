package de.neuefische.booklibrary.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import de.neuefische.booklibrary.repo.Book;
import de.neuefische.booklibrary.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public List<Book> getBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{isbn}")
    public Book getBooks(@PathVariable String isbn) {
        return bookService.getBookByISBN(isbn);
    }

    //@PutMapping("/{isbn}")
    //public Book putBook(@PathVariable String isbn) {
    //    return
    //}


}
