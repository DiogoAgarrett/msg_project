package exercicio2.dtos;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TableOfContentsDTO {
    private String bookName;
    private String editionName;
    private int totalEntries;
    private List<EntryDTO> contents = new ArrayList<>();


    public TableOfContentsDTO() {}

    public TableOfContentsDTO(String bookName, String editionName, int totalEntries) {
        this.bookName = bookName;
        this.editionName = editionName;
        this.totalEntries = totalEntries;
    }

    public String getBookName() { return bookName; }
    public void setBookName(String bookName) { this.bookName = bookName; }

    public String getEditionName() { return editionName; }
    public void setEditionName(String editionName) { this.editionName = editionName; }

    public int getTotalEntries() { return totalEntries; }
    public void setTotalEntries(int totalEntries) { this.totalEntries = totalEntries; }

    public List<EntryDTO> getContents() { return contents; }
    public void setContents(List<EntryDTO> contents) { this.contents = contents; }
}