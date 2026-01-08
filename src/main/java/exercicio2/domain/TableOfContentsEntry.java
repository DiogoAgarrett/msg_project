package exercicio2.domain;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "table_of_contents_entries")
public class TableOfContentsEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(name = "entry_order", nullable = false)
    private int order;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private TableOfContentsEntry parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<TableOfContentsEntry> children = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "edition_id", nullable = false)
    private Edition edition;

    public TableOfContentsEntry() {}

    public TableOfContentsEntry(String title, int order, Edition edition) {
        this.title = title;
        this.order = order;
        this.edition = edition;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public TableOfContentsEntry getParent() {
        return parent;
    }

    public void setParent(TableOfContentsEntry parent) {
        this.parent = parent;
    }

    public List<TableOfContentsEntry> getChildren() {
        return children;
    }

    public void setChildren(List<TableOfContentsEntry> children) {
        this.children = children;
    }

    public Edition getEdition() {
        return edition;
    }

    public void setEdition(Edition edition) {
        this.edition = edition;
    }
}