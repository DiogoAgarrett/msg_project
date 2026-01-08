package exercicio2.domain;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "editions")
public class Edition {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String editionName;
    @Column(nullable = false)
    private String editionNumber;


    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @OneToMany(mappedBy = "edition", cascade = CascadeType.ALL)
    private List<TableOfContentsEntry> contents = new ArrayList<>();

    public Edition() {}

    public Edition(String editionName, String editionNumber, Book book) {
        this.editionName = editionName;
        this.editionNumber = editionNumber;
        this.book = book;
    }

    public UUID getId() { return id; }
    public String getEditionNumber() { return editionNumber; }
    public String getEditionName() {
        return editionName;
    }
    public Book getBook() {
        return book;
    }
    public List<TableOfContentsEntry> getContents() {
        return contents;
    }

    public void setId(UUID id) {
        this.id = id;
    }
    public void setEditionName(String editionName) {
        this.editionName = editionName;
    }
    public void setEditionNumber(String editionNumber) { this.editionNumber = editionNumber; }
    public void setBook(Book book) {
        this.book = book;
    }
    public void setContents(List<TableOfContentsEntry> contents) {
        this.contents = contents;
    }
}