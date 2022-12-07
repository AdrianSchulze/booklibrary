package de.neuefische.booklibrary.repo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class BookRepoTest {

    @Test
    void getBookList() {
        //GIVEN
        BookRepo bookRepo = new BookRepo();
        List<Book> bookList = new ArrayList<>(
                List.of(
                        new Book("0345391802","Krieg der Sterne","Irgendein Lukas",BookType.E_BOOK),
                        new Book("1230123912","Das Dschungel Buch","Walther Disney",BookType.HEARBOOK))
        );
        //WHEN
        List<Book> actual = bookRepo.getBookList();
        //THEN
        Assertions.assertEquals(bookList, actual);
    }

    @Test
    void getBookByISBN() {
        //GIVEN
        BookRepo bookRepo = new BookRepo();
        //WHEN
        Book actual = bookRepo.getBookByISBN("0345391802");
        //THEN
        Assertions.assertEquals(new Book("0345391802","Krieg der Sterne","Irgendein Lukas",BookType.E_BOOK), actual);
    }

    @Test
    void setBookList() {
        //GIVEN
        BookRepo bookRepo = new BookRepo();
        List<Book> bookList = new ArrayList<>(
                List.of(
                        new Book("0345391802","Krieg der Sterne","Irgendein Lukas",BookType.E_BOOK),
                        new Book("1230123912","Das Dschungel Buch","Walther Disney",BookType.HEARBOOK))
        );
        //WHEN
        bookRepo.setBookList(bookList);
        List<Book> actual = bookRepo.getBookList();
        //THEN
        Assertions.assertEquals(bookList, actual);

    }
}