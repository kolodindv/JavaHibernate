package Entities;

//import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;
@Entity
@Table (name = "Coach")
public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCoach;
    @Column(name = "firstName", length = 20)
    private String firstName;
    @Column(name = "lastName", length = 20)
    private String lastName;
    @Column(name = "telephoneNumber", length = 11)
    private String telephoneNumber;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mainHall")
    private Hall mainHall;
    @ManyToMany
    @JoinTable(name = "CoachBySport", joinColumns = @JoinColumn(name = "idCoach"),
            inverseJoinColumns =@JoinColumn(name = "idKind") )
    @JsonManagedReference
    private Set <KindSport> kindsSport;
    @ManyToMany
    @JoinTable(name = "GroupByCoach", joinColumns = @JoinColumn(name = "idCoach"),
            inverseJoinColumns =@JoinColumn(name = "idGroup") )
    private Set <SportGroup> groups;

    public Coach () {}
    public Coach(String firstName, String lastName, String telephoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNumber = telephoneNumber;
    }

    public int getIdCoach() {
        return idCoach;
    }

    public void setIdCoach(int idCoach) {
        this.idCoach = idCoach;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public Hall getMainHall() {
        return mainHall;
    }

    public void setMainHall(Hall mainHall) {
        this.mainHall = mainHall;
    }

    public Set<KindSport> getKindsSport() {
        return kindsSport;
    }

    public void setKindsSport(Set<KindSport> kindsSport) {
        this.kindsSport = kindsSport;
    }

    public Set<SportGroup> getGroups() {
        return groups;
    }

    public void setGroups(Set<SportGroup> groups) {
        this.groups = groups;
    }
}
