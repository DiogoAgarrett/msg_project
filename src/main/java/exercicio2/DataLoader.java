package exercicio2;

import exercicio2.domain.*;
import exercicio2.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final EditionRepository editionRepository;
    private final TableOfContentsEntryRepository entryRepository;

    public DataLoader(BookRepository bookRepository,
                      EditionRepository editionRepository,
                      TableOfContentsEntryRepository entryRepository) {
        this.bookRepository = bookRepository;
        this.editionRepository = editionRepository;
        this.entryRepository = entryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Book book = new Book("Clean Code", "CLEANCODE");
        bookRepository.save(book);

        Edition edition = new Edition("1st Edition", "1st", book);
        editionRepository.save(edition);

        TableOfContentsEntry parte1 = new TableOfContentsEntry("Parte 1", 1, edition);
        entryRepository.save(parte1);

        TableOfContentsEntry cap1 = new TableOfContentsEntry("Cap 1", 1, edition);
        cap1.setParent(parte1);
        entryRepository.save(cap1);

        TableOfContentsEntry cap11 = new TableOfContentsEntry("Cap 1.1", 1, edition);
        cap11.setParent(cap1);
        entryRepository.save(cap11);

        System.out.println("✅ Test data created!");
    }
}