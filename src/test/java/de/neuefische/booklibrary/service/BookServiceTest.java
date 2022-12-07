package de.neuefische.booklibrary.service;

import de.neuefische.booklibrary.repo.Book;
import de.neuefische.booklibrary.repo.BookRepo;
import de.neuefische.booklibrary.repo.BookType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class BookServiceTest {

    @Test
    void getAllBooks() {
        //GIVEN
        BookRepo bookRepo = mock(BookRepo.class);
        BookService bookService = new BookService(bookRepo);

        List<Book> bookList = new ArrayList<>(
                List.of(
                        new Book("0345391802","Krieg der Sterne","Irgendein Lukas", BookType.E_BOOK),
                        new Book("1230123912","Das Dschungel Buch","Walther Disney",BookType.HEARBOOK))
        );
        //WHEN & THEN
        when(bookRepo.getBookList()).thenReturn(bookList);
        List<Book> actual = bookService.getAllBooks();

        Assertions.assertEquals(bookList,actual);
        verify(bookRepo).getBookList();
    }

    @Test
    void getBookByISBN() {
        //GIVEN
        BookRepo bookRepo = mock(BookRepo.class);
        BookService bookService = new BookService(bookRepo);
        //WHEN & THEN
        when(bookRepo.getBookByISBN("0345391802")).thenReturn(new Book("0345391802","Krieg der Sterne","Irgendein Lukas", BookType.E_BOOK));
        Book actual = bookService.getBookByISBN("0345391802");

        Assertions.assertEquals(new Book("0345391802","Krieg der Sterne","Irgendein Lukas", BookType.E_BOOK),actual);
        verify(bookRepo).getBookByISBN("0345391802");
    }
}