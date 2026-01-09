package exercicio2.controllers;

import exercicio2.dtos.BookDTO;
import exercicio2.dtos.EditionDTO;
import exercicio2.dtos.TableOfContentsDTO;
import exercicio2.services.TableOfContentsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class TableOfContentsController {

    private final TableOfContentsService service;

    public TableOfContentsController(TableOfContentsService service) {
        this.service = service;
    }

    @GetMapping("/books/{bookCode}/editions/{editionNumber}/table-of-contents")
    public ResponseEntity<TableOfContentsDTO> getTableOfContents(
            @PathVariable String bookCode,
            @PathVariable String editionNumber) {

        TableOfContentsDTO dto = service.getTableOfContents(bookCode, editionNumber);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/books")
    public ResponseEntity<List<BookDTO>> getAllBooks(){
        List<BookDTO> books = service.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/books/{bookCode}/editions")
    public ResponseEntity<List<EditionDTO>> getEditionsByBook(@PathVariable String bookCode) {
        List<EditionDTO> editions = service.getEditionsByBookCode(bookCode);
        return ResponseEntity.ok(editions);
    }


}