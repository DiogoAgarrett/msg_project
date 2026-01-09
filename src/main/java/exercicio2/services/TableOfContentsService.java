package exercicio2.services;

import exercicio2.domain.Book;
import exercicio2.domain.Edition;
import exercicio2.domain.TableOfContentsEntry;
import exercicio2.dtos.BookDTO;
import exercicio2.dtos.EditionDTO;
import exercicio2.dtos.EntryDTO;
import exercicio2.dtos.TableOfContentsDTO;
import exercicio2.repositories.BookRepository;
import exercicio2.repositories.EditionRepository;
import exercicio2.repositories.TableOfContentsEntryRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TableOfContentsService {

    private final EditionRepository editionRepository;
    private final TableOfContentsEntryRepository entryRepository;
    private final BookRepository bookRepository;

    public TableOfContentsService(EditionRepository editionRepository,
                                  TableOfContentsEntryRepository entryRepository,
                                  BookRepository bookRepository) {
        this.editionRepository = editionRepository;
        this.entryRepository = entryRepository;
        this.bookRepository = bookRepository;
    }

    public TableOfContentsDTO getTableOfContents(String bookCode, String editionNumber) {
        Edition edition = editionRepository.findByEditionNumberAndBook_Code(editionNumber, bookCode)
                .orElseThrow(() -> new RuntimeException("Edition not found"));

        List<TableOfContentsEntry> allEntries = entryRepository.findByEditionId(edition.getId());

        List<TableOfContentsEntry> roots = allEntries.stream()
                .filter(e -> e.getParent() == null)
                .sorted((a, b) -> Integer.compare(a.getOrder(), b.getOrder()))
                .collect(Collectors.toList());

        List<EntryDTO> contentsDTO = roots.stream()
                .map(root -> buildEntryDTO(root, allEntries))
                .collect(Collectors.toList());

        TableOfContentsDTO dto = new TableOfContentsDTO(
                edition.getBook().getTitle(),
                edition.getEditionName(),
                allEntries.size()
        );
        dto.setContents(contentsDTO);

        return dto;
    }

    private EntryDTO buildEntryDTO(TableOfContentsEntry entry, List<TableOfContentsEntry> allEntries) {
        EntryDTO dto = new EntryDTO(entry.getTitle(), entry.getOrder());

        List<TableOfContentsEntry> children = allEntries.stream()
                .filter(e -> e.getParent() != null && e.getParent().getId().equals(entry.getId()))
                .sorted((a, b) -> Integer.compare(a.getOrder(), b.getOrder()))
                .collect(Collectors.toList());

        List<EntryDTO> childrenDTO = children.stream()
                .map(child -> buildEntryDTO(child, allEntries))
                .collect(Collectors.toList());

        dto.setChildren(childrenDTO);
        return dto;
    }

    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(book -> new BookDTO(book.getCode(), book.getTitle()))
                .collect(Collectors.toList());
    }

    public List<EditionDTO> getEditionsByBookCode(String bookCode) {
        Book book = bookRepository.findByCode(bookCode)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        return book.getEditions().stream()
                .map(edition -> new EditionDTO(edition.getEditionNumber(), edition.getEditionName()))
                .collect(Collectors.toList());
    }
}