package jp.co.kelly.restapi;

import jp.co.kelly.service.BookService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BooksApiImpl.class)
class BooksApiImplTests {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    public BookService service;

    @Test
    void booksGet() throws Exception {

        String expectJson = "{\n" +
                "  \"isbns\": null\n" +
                "}";

        Mockito.when(service.execute(Mockito.any())).thenReturn(null);

        mockMvc.perform(get("/v1/books"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectJson, true));

        Mockito.verify(service).execute(null);
    }
}