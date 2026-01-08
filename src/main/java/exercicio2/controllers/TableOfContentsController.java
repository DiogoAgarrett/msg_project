package exercicio2.controllers;

import exercicio2.dtos.TableOfContentsDTO;
import exercicio2.services.TableOfContentsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
}