package Entities;

import javax.persistence.*;
import java.util.Set;
@Entity
@Table(name = "Hall")
public class Hall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHall;
    @Column(name = "nameOfHall", length = 10)
    private String nameOfHall;
    @ManyToMany
    @JoinTable(name = "HallByGroup", joinColumns = @JoinColumn(name = "idHall"),
            inverseJoinColumns =@JoinColumn(name = "idGroup") )
    Set <SportGroup> groups;

    public Hall () {}
    public Hall(String nameOfHall) {
        this.nameOfHall = nameOfHall;
    }

    public int getIdHall() {
        return idHall;
    }

    public void setIdHall(int idHall) {
        this.idHall = idHall;
    }

    public String getNameOfHall() {
        return nameOfHall;
    }

    public void setNameOfHall(String nameOfHall) {
        this.nameOfHall = nameOfHall;
    }

    public Set<SportGroup> getGroups() {
        return groups;
    }

    public void setGroups(Set<SportGroup> groups) {
        this.groups = groups;
    }
}
