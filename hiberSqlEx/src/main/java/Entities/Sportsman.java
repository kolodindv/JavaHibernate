package Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name = "Sportsman")
public class Sportsman extends Client {
    @Column(name = "discharge", length = 100)
    private String discharge ;

    public Sportsman() {}
    public Sportsman(String firstName, String lastName, String telephoneNumber, String discharge) {
        super(firstName, lastName, telephoneNumber);
        this.discharge = discharge;
    }

    public String getDischarge() {
        return discharge;
    }
    public void setDischarge(String discharge) {
        this.discharge = discharge;
    }
}

