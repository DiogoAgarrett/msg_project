package exercicio2.dtos;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EntryDTO {
    private String title;
    private int order;
    private List<EntryDTO> children = new ArrayList<>();

    public EntryDTO() {}

    public EntryDTO(String title, int order) {
        this.title = title;
        this.order = order;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public int getOrder() { return order; }
    public void setOrder(int order) { this.order = order; }

    public List<EntryDTO> getChildren() { return children; }
    public void setChildren(List<EntryDTO> children) { this.children = children; }
}