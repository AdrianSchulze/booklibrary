package de.neuefische.booklibrary.repo;

import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Data
@Repository
public class BookRepo {
    private List<Book> bookList = new ArrayList<>(
            List.of(
                    new Book("0345391802","Krieg der Sterne","Irgendein Lukas",BookType.E_BOOK),
                    new Book("1230123912","Das Dschungel Buch","Walther Disney",BookType.HEARBOOK))
    );


    public Book getBookByISBN(String isbn) {
        Book book = null;

        for (Book b : bookList) {
            if (b.getIsbn().equals(isbn)) {
                book = b;
                break;
            }
        }
        return book;
    }
}
