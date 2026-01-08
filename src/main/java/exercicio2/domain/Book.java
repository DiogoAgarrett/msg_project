package exercicio2.domain;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String title;
    @Column(nullable = false, unique = true)
    private String code;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Edition> editions = new ArrayList<>();

    public Book() {}

    public Book(String title, String code) {
        this.title = title;
        this.code = code;
    }

    public UUID getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getCode(){
        return code;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setCode(String code){
        this.code = code;
    }

    public List<Edition> getEditions() {
        return editions;
    }

    public void setEditions(List<Edition> editions) {
        this.editions = editions;
    }
}