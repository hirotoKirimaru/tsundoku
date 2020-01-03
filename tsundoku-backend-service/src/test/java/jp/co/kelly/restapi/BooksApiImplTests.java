package jp.co.kelly.restapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BooksApiImpl.class)
class BooksApiImplTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void booksGet() throws Exception {

        String expectJson = "{\n" +
                "  \"isbns\": null\n" +
                "}";

        mockMvc.perform(get("/v1/books"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectJson, true));
    }
}