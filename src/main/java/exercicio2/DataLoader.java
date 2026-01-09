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
        Book cleanCode = new Book("Clean Code", "CLEANCODE");
        bookRepository.save(cleanCode);

        Edition cleanCode1st = new Edition("1st Edition", "1st", cleanCode);
        editionRepository.save(cleanCode1st);

        TableOfContentsEntry cc1_parte1 = new TableOfContentsEntry("Clean Code", 1, cleanCode1st);
        entryRepository.save(cc1_parte1);

        TableOfContentsEntry cc1_cap1 = new TableOfContentsEntry("Chapter 1: Clean Code", 1, cleanCode1st);
        cc1_cap1.setParent(cc1_parte1);
        entryRepository.save(cc1_cap1);

        TableOfContentsEntry cc1_cap2 = new TableOfContentsEntry("Chapter 2: Meaningful Names", 2, cleanCode1st);
        cc1_cap2.setParent(cc1_parte1);
        entryRepository.save(cc1_cap2);

        TableOfContentsEntry cc1_parte2 = new TableOfContentsEntry("Functions", 2, cleanCode1st);
        entryRepository.save(cc1_parte2);

        TableOfContentsEntry cc1_cap3 = new TableOfContentsEntry("Chapter 3: Functions", 1, cleanCode1st);
        cc1_cap3.setParent(cc1_parte2);
        entryRepository.save(cc1_cap3);

        TableOfContentsEntry cc1_sec31 = new TableOfContentsEntry("Small Functions", 1, cleanCode1st);
        cc1_sec31.setParent(cc1_cap3);
        entryRepository.save(cc1_sec31);

        TableOfContentsEntry cc1_sec32 = new TableOfContentsEntry("Do One Thing", 2, cleanCode1st);
        cc1_sec32.setParent(cc1_cap3);
        entryRepository.save(cc1_sec32);

        Edition cleanCode2nd = new Edition("2nd Edition", "2nd", cleanCode);
        editionRepository.save(cleanCode2nd);

        TableOfContentsEntry cc2_parte1 = new TableOfContentsEntry("Introduction to Clean Code", 1, cleanCode2nd);
        entryRepository.save(cc2_parte1);

        TableOfContentsEntry cc2_cap1 = new TableOfContentsEntry("Why Clean Code Matters", 1, cleanCode2nd);
        cc2_cap1.setParent(cc2_parte1);
        entryRepository.save(cc2_cap1);

        Book designPatterns = new Book("Design Patterns", "DESIGNPATTERNS");
        bookRepository.save(designPatterns);

        Edition dp1st = new Edition("1st Edition", "1st", designPatterns);
        editionRepository.save(dp1st);

        TableOfContentsEntry dp_creational = new TableOfContentsEntry("Creational Patterns", 1, dp1st);
        entryRepository.save(dp_creational);

        TableOfContentsEntry dp_singleton = new TableOfContentsEntry("Singleton", 1, dp1st);
        dp_singleton.setParent(dp_creational);
        entryRepository.save(dp_singleton);

        TableOfContentsEntry dp_factory = new TableOfContentsEntry("Factory Method", 2, dp1st);
        dp_factory.setParent(dp_creational);
        entryRepository.save(dp_factory);

        TableOfContentsEntry dp_builder = new TableOfContentsEntry("Builder", 3, dp1st);
        dp_builder.setParent(dp_creational);
        entryRepository.save(dp_builder);

        TableOfContentsEntry dp_structural = new TableOfContentsEntry("Structural Patterns", 2, dp1st);
        entryRepository.save(dp_structural);

        TableOfContentsEntry dp_adapter = new TableOfContentsEntry("Adapter", 1, dp1st);
        dp_adapter.setParent(dp_structural);
        entryRepository.save(dp_adapter);

        TableOfContentsEntry dp_decorator = new TableOfContentsEntry("Decorator", 2, dp1st);
        dp_decorator.setParent(dp_structural);
        entryRepository.save(dp_decorator);

        TableOfContentsEntry dp_behavioral = new TableOfContentsEntry("Behavioral Patterns", 3, dp1st);
        entryRepository.save(dp_behavioral);

        TableOfContentsEntry dp_observer = new TableOfContentsEntry("Observer", 1, dp1st);
        dp_observer.setParent(dp_behavioral);
        entryRepository.save(dp_observer);

        TableOfContentsEntry dp_strategy = new TableOfContentsEntry("Strategy", 2, dp1st);
        dp_strategy.setParent(dp_behavioral);
        entryRepository.save(dp_strategy);

        Edition dp2nd = new Edition("2nd Edition", "2nd", designPatterns);
        editionRepository.save(dp2nd);

        TableOfContentsEntry dp2_intro = new TableOfContentsEntry("Introduction", 1, dp2nd);
        entryRepository.save(dp2_intro);

        TableOfContentsEntry dp2_modern = new TableOfContentsEntry("Modern Design Patterns", 2, dp2nd);
        entryRepository.save(dp2_modern);

        Book effectiveJava = new Book("Effective Java", "EFFECTIVEJAVA");
        bookRepository.save(effectiveJava);

        Edition ej3rd = new Edition("3rd Edition", "3rd", effectiveJava);
        editionRepository.save(ej3rd);

        TableOfContentsEntry ej_create = new TableOfContentsEntry("Creating and Destroying Objects", 1, ej3rd);
        entryRepository.save(ej_create);

        TableOfContentsEntry ej_item1 = new TableOfContentsEntry("Item 1: Consider static factory methods", 1, ej3rd);
        ej_item1.setParent(ej_create);
        entryRepository.save(ej_item1);

        TableOfContentsEntry ej_item2 = new TableOfContentsEntry("Item 2: Consider a builder", 2, ej3rd);
        ej_item2.setParent(ej_create);
        entryRepository.save(ej_item2);

        TableOfContentsEntry ej_item3 = new TableOfContentsEntry("Item 3: Enforce singleton with private constructor", 3, ej3rd);
        ej_item3.setParent(ej_create);
        entryRepository.save(ej_item3);

        TableOfContentsEntry ej_methods = new TableOfContentsEntry("Methods Common to All Objects", 2, ej3rd);
        entryRepository.save(ej_methods);

        TableOfContentsEntry ej_item10 = new TableOfContentsEntry("Item 10: Obey the general contract when overriding equals", 1, ej3rd);
        ej_item10.setParent(ej_methods);
        entryRepository.save(ej_item10);

        TableOfContentsEntry ej_item11 = new TableOfContentsEntry("Item 11: Always override hashCode when you override equals", 2, ej3rd);
        ej_item11.setParent(ej_methods);
        entryRepository.save(ej_item11);

        TableOfContentsEntry ej_classes = new TableOfContentsEntry("Classes and Interfaces", 3, ej3rd);
        entryRepository.save(ej_classes);

        TableOfContentsEntry ej_item15 = new TableOfContentsEntry("Item 15: Minimize mutability", 1, ej3rd);
        ej_item15.setParent(ej_classes);
        entryRepository.save(ej_item15);

        Book pragProg = new Book("The Pragmatic Programmer", "PRAGPROG");
        bookRepository.save(pragProg);

        Edition pp20th = new Edition("20th Anniversary Edition", "20th", pragProg);
        editionRepository.save(pp20th);

        TableOfContentsEntry pp_philosophy = new TableOfContentsEntry("A Pragmatic Philosophy", 1, pp20th);
        entryRepository.save(pp_philosophy);

        TableOfContentsEntry pp_topic1 = new TableOfContentsEntry("Topic 1: It's Your Life", 1, pp20th);
        pp_topic1.setParent(pp_philosophy);
        entryRepository.save(pp_topic1);

        TableOfContentsEntry pp_topic2 = new TableOfContentsEntry("Topic 2: The Cat Ate My Source Code", 2, pp20th);
        pp_topic2.setParent(pp_philosophy);
        entryRepository.save(pp_topic2);

        TableOfContentsEntry pp_approach = new TableOfContentsEntry("A Pragmatic Approach", 2, pp20th);
        entryRepository.save(pp_approach);

        TableOfContentsEntry pp_topic8 = new TableOfContentsEntry("Topic 8: The Essence of Good Design", 1, pp20th);
        pp_topic8.setParent(pp_approach);
        entryRepository.save(pp_topic8);

        TableOfContentsEntry pp_topic9 = new TableOfContentsEntry("Topic 9: DRY - The Evils of Duplication", 2, pp20th);
        pp_topic9.setParent(pp_approach);
        entryRepository.save(pp_topic9);

        TableOfContentsEntry pp_tools = new TableOfContentsEntry("The Basic Tools", 3, pp20th);
        entryRepository.save(pp_tools);

        TableOfContentsEntry pp_topic14 = new TableOfContentsEntry("Topic 14: The Power of Plain Text", 1, pp20th);
        pp_topic14.setParent(pp_tools);
        entryRepository.save(pp_topic14);

        Book refactoring = new Book("Refactoring", "REFACTORING");
        bookRepository.save(refactoring);

        Edition ref2nd = new Edition("2nd Edition", "2nd", refactoring);
        editionRepository.save(ref2nd);

        TableOfContentsEntry ref_chapter1 = new TableOfContentsEntry("Chapter 1: Refactoring: A First Example", 1, ref2nd);
        entryRepository.save(ref_chapter1);

        TableOfContentsEntry ref_starting = new TableOfContentsEntry("The Starting Point", 1, ref2nd);
        ref_starting.setParent(ref_chapter1);
        entryRepository.save(ref_starting);

        TableOfContentsEntry ref_first = new TableOfContentsEntry("The First Step in Refactoring", 2, ref2nd);
        ref_first.setParent(ref_chapter1);
        entryRepository.save(ref_first);

        TableOfContentsEntry ref_chapter2 = new TableOfContentsEntry("Chapter 2: Principles in Refactoring", 2, ref2nd);
        entryRepository.save(ref_chapter2);

        TableOfContentsEntry ref_defining = new TableOfContentsEntry("Defining Refactoring", 1, ref2nd);
        ref_defining.setParent(ref_chapter2);
        entryRepository.save(ref_defining);

        TableOfContentsEntry ref_two_hats = new TableOfContentsEntry("The Two Hats", 2, ref2nd);
        ref_two_hats.setParent(ref_chapter2);
        entryRepository.save(ref_two_hats);

        TableOfContentsEntry ref_catalog = new TableOfContentsEntry("A Catalog of Refactorings", 3, ref2nd);
        entryRepository.save(ref_catalog);

        TableOfContentsEntry ref_extract = new TableOfContentsEntry("Extract Function", 1, ref2nd);
        ref_extract.setParent(ref_catalog);
        entryRepository.save(ref_extract);

        TableOfContentsEntry ref_inline = new TableOfContentsEntry("Inline Function", 2, ref2nd);
        ref_inline.setParent(ref_catalog);
        entryRepository.save(ref_inline);

        TableOfContentsEntry ref_variable = new TableOfContentsEntry("Extract Variable", 3, ref2nd);
        ref_variable.setParent(ref_catalog);
        entryRepository.save(ref_variable);

        System.out.println("✅ Test data created with 5 books and multiple editions!");
    }
}