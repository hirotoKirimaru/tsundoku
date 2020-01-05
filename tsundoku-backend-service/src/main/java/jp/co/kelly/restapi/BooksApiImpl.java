package jp.co.kelly.restapi;

import jp.co.kelly.restapi.dto.BooksDto;
import jp.co.kelly.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1")
@RestController
@RequiredArgsConstructor
public class BooksApiImpl implements BooksApi {
    private final BookService service;

    @Override
    public ResponseEntity<BooksDto> booksGet() {
        service.execute(null);
        return ResponseEntity.ok(new BooksDto());
    }
}
