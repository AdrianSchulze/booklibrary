package de.neuefische.booklibrary;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void getAllBooks() throws Exception {
        String expectedJSON = """
[
    {
        "isbn": "0345391802",
        "title": "Krieg der Sterne",
        "author": "Irgendein Lukas",
        "type": "E_BOOK"
    },
    {
        "isbn": "1230123912",
        "title": "Das Dschungel Buch",
        "author": "Walther Disney",
        "type": "HEARBOOK"
    }
]
""";
        //WHEN & THEN
        mvc.perform(MockMvcRequestBuilders.get("/books"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJSON,true));
    }

    @Test
    void getBooksByIdGivesBooksByIdBack() throws Exception {
        //GIVEN
        String expectedJSON = """
                {
                    "isbn": "0345391802",
                    "title": "Krieg der Sterne",
                    "author": "Irgendein Lukas",
                    "type": "E_BOOK"
                }
                """;

        //WHEN & THEN
        mvc.perform(MockMvcRequestBuilders.get("/books/0345391802"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJSON));
    }
}
