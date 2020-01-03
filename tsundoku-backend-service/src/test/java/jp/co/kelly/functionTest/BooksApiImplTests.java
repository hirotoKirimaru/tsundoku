package jp.co.kelly.functionTest;

import jp.co.kelly.restapi.dto.BooksDto;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import java.net.URI;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BooksApiImplTests {
    @Autowired
    private TestRestTemplate restTemplate;

    private SoftAssertions softly;

    @BeforeEach
    void setup() {
        softly = new SoftAssertions();
    }

    @AfterEach
    void tearDown() {
        softly.assertAll();
    }

    @Test
    void booksGet() throws Exception {
        URI url = URI.create("/v1/books");
        RequestEntity req = RequestEntity.get(url).build();
        ResponseEntity<BooksDto> res = restTemplate.exchange(req, BooksDto.class);

        softly.assertThat(res.getBody().getIsbns()).isNull();
        softly.assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

}