package exercicio2.dtos;

public class EditionDTO {
    private String editionNumber;
    private String editionName;

    public EditionDTO() {}

    public EditionDTO(String editionNumber, String editionName) {
        this.editionNumber = editionNumber;
        this.editionName = editionName;
    }

    public String getEditionNumber() {
        return editionNumber;
    }

    public void setEditionNumber(String editionNumber) {
        this.editionNumber = editionNumber;
    }

    public String getEditionName() {
        return editionName;
    }

    public void setEditionName(String editionName) {
        this.editionName = editionName;
    }
}