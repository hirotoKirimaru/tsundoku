package jp.co.kelly.restapi;

import jp.co.kelly.restapi.dto.BooksDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1")
@RestController
public class BooksApiImpl implements BooksApi {
    @Override
    public ResponseEntity<BooksDto> booksGet() {
        return ResponseEntity.ok(new BooksDto());
    }
}
