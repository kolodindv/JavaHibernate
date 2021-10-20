package Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name = "Referee")
public class Referee extends Client {
    @Column(name = "category", length = 100)
    private String category;

    public Referee() {}
    public Referee(String firstName, String lastName, String telephoneNumber, String category) {
        super(firstName, lastName, telephoneNumber);
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
