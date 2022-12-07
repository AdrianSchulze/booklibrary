package de.neuefische.booklibrary.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import de.neuefische.booklibrary.repo.Book;
import de.neuefische.booklibrary.repo.BookRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepo bookRepo;

    public List<Book> getAllBooks() {
        return bookRepo.getBookList();
    }

    public Book getBookByISBN(String isbn) {
        return bookRepo.getBookByISBN(isbn);
    }

}
